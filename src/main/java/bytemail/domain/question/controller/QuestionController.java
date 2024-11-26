package bytemail.domain.question.controller;

import bytemail.domain.question.dto.QuestionResponse;
import bytemail.domain.question.service.QuestionService;
import bytemail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question")
    public ResponseEntity<PageResponse<QuestionResponse>> getQuestion(@RequestParam(defaultValue = "all") String category,
                                                                      @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        PageResponse<QuestionResponse> response = questionService.getQuestions(category, pageable);
        return ResponseEntity.ok(response);
    }

}
