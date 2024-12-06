package techmail.domain.userquestion.service;

import techmail.domain.question.dto.QuestionResDto;
import techmail.domain.userquestion.repository.UserQuestionRepository;
import techmail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQuestionService {

    private final UserQuestionRepository userQuestionRepository;

    public PageResponse<QuestionResDto> getUserQuestionList(String email, Pageable pageable) {
        Page<QuestionResDto> questionResponses = userQuestionRepository.selectUserQuestionPageList(email, pageable);
        return new PageResponse<>(questionResponses);
    }

}
