package techmail.domain.user.service;

import techmail.domain.mail.dto.MailDto;
import techmail.domain.mail.service.MailService;
import techmail.domain.question.entity.QuestionCategory;
import techmail.domain.user.dto.SendVerifyCodeReqDto;
import techmail.domain.user.dto.CreateUserReqDto;
import techmail.domain.user.dto.DeleteUserReqDto;
import techmail.domain.user.entity.User;
import techmail.domain.user.repository.UserRepository;
import techmail.domain.user.view.WelcomeView;
import techmail.domain.user.view.VerifyCodeView;
import techmail.global.exception.BusinessException;
import techmail.global.exception.ErrorCode;
import techmail.global.util.VerifyCodeGenerator;
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
             User user = new User(request.email(), QuestionCategory.from(request.category()));
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
