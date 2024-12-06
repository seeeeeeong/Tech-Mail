package techmail.domain.userquestion.repository;

import techmail.domain.question.dto.QuestionResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserQuestionQueryRepository {
    Page<QuestionResDto> selectUserQuestionPageList(String email, Pageable pageable);
}
