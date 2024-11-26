package bytemail.domain.question.repository;

import bytemail.domain.question.dto.QuestionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionQueryRepository {
    Page<QuestionResponse> findQuestions(String category, Pageable pageable);
}
