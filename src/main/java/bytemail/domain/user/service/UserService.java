package bytemail.domain.user.service;

import bytemail.domain.mail.dto.MailDto;
import bytemail.domain.mail.service.MailService;
import bytemail.domain.user.dto.SendVerifyCodeReqDto;
import bytemail.domain.user.dto.CreateUserReqDto;
import bytemail.domain.user.dto.DeleteUserReqDto;
import bytemail.domain.user.entity.User;
import bytemail.domain.user.repository.UserRepository;
import bytemail.domain.user.view.WelcomeView;
import bytemail.domain.user.view.VerifyCodeView;
import bytemail.global.exception.BusinessException;
import bytemail.global.exception.ErrorCode;
import bytemail.global.util.VerifyCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final VerifyCodeGenerator verifyCodeGenerator;

    private final TempUserService tempUserService;
    private final MailService mailService;

    private final UserRepository userRepository;

    private final VerifyCodeView verifyCodeView;
    private final WelcomeView welcomeView;

    @Transactional
    public void sendVerifyCode(SendVerifyCodeReqDto request) {
        String subject = "회원가입 이메일 인증 안내";
        String code = verifyCodeGenerator.generateCode();
        String text = createVerifyText(code);
        MailDto mailDto = new MailDto(request.email(), subject, text, verifyCodeView.getType());

        mailService.sendMail(mailDto);
        tempUserService.createTempUser(request.email(), code);
    }

    @Transactional
    public void createUser(CreateUserReqDto request) {
        tempUserService.verify(request.email(), request.code());

        boolean isUserExists = userRepository.isUserExists(request.email());

         if (!isUserExists) {
             User user = new User(request.email());
             userRepository.save(user);
            }

        String subject = "가입을 축하드립니다!";
        String text = createWelcomeView();
        MailDto mailDto = new MailDto(request.email(), subject, text, welcomeView.getType());
        mailService.sendMail(mailDto);
    }

    @Transactional
    public void deleteUser(DeleteUserReqDto request) {
        User user = userRepository.selectUser(request.email(), request.token())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        user.deleteUser();
    }

    private String createVerifyText(String code) {
        Map<Object, Object> attribute = new HashMap<>();
        attribute.put("code", code);

        return verifyCodeView.render(attribute);
    }

    private String createWelcomeView() {
        Map<Object, Object> attribute = new HashMap<>();

        return welcomeView.render(attribute);
    }
}
