package bytemail.domain.userquestion.controller;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.userquestion.service.UserQuestionScheduler;
import bytemail.domain.userquestion.service.UserQuestionService;
import bytemail.global.response.ApiResponse;
import bytemail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserQuestionController {

    private final UserQuestionService userQuestionService;
    private final UserQuestionScheduler userQuestionScheduler;

    @GetMapping("/user-question")
    public ApiResponse<PageResponse<QuestionResDto>> getUserQuestionList(@RequestParam String email,
                                                                         @PageableDefault(sort = {"id"}, size =  200) Pageable pageable) {
        return ApiResponse.success(userQuestionService.getUserQuestionList(email, pageable));
    }

    @PostMapping("/send-mail-scheduling")
    public ApiResponse<Void> sendMailScheduling() {
        userQuestionScheduler.sendMail();
        return ApiResponse.success(null);
    }

}
