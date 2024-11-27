package bytemail.domain.userquestion.service;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.userquestion.repository.UserQuestionRepository;
import bytemail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQuestionService {

    private final UserQuestionRepository subscribeQuestionRepository;

    public PageResponse<QuestionResDto> getUserQuestionList(String email, Pageable pageable) {
        Page<QuestionResDto> questionResponses = subscribeQuestionRepository.selectUserQuestionPageList(email, pageable);
        return new PageResponse<>(questionResponses);
    }

}
