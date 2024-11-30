package bytemail.domain.userquestion.repository;

import bytemail.domain.question.dto.QuestionResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserQuestionQueryRepository {
    Page<QuestionResDto> selectUserQuestionPageList(String email, Pageable pageable);
}
