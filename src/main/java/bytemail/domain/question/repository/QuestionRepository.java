package bytemail.domain.question.repository;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionQueryRepository {

}
