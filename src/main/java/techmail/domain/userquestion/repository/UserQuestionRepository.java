package techmail.domain.userquestion.repository;

import techmail.domain.user.entity.User;
import techmail.domain.userquestion.entity.UserQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserQuestionRepository extends JpaRepository<UserQuestion, Long>, UserQuestionQueryRepository {
    List<UserQuestion> findUserQuestionByCreatedAtBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
    List<UserQuestion> findByUser(User user);
}
