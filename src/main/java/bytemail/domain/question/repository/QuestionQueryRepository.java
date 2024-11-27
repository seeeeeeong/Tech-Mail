package bytemail.domain.question.repository;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryRepository {
    Page<QuestionResDto> selectQuestionPageList(Pageable pageable);

    Optional<QuestionResDto> selectQuestionDetail(Long questionId);

    Optional<QuestionResDto> selectQuestionListNotIn(User user);

    List<QuestionResDto> findAllQuestions();

}
