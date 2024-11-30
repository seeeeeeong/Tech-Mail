package bytemail.domain.userquestion.service;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.user.entity.User;
import bytemail.domain.userquestion.entity.UserQuestion;
import bytemail.domain.userquestion.repository.UserQuestionRepository;
import bytemail.global.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQuestionService {

    private final UserQuestionRepository userQuestionRepository;

    public PageResponse<QuestionResDto> getUserQuestionList(String email, Pageable pageable) {
        Page<QuestionResDto> questionResponses = userQuestionRepository.selectUserQuestionPageList(email, pageable);
        return new PageResponse<>(questionResponses);
    }

}
