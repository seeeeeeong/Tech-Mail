package bytemail.domain.user.repository;

import bytemail.domain.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserQueryRepository {
    List<String> selectEmailList();

    boolean isUserExists(String email);

    Optional<User> selectUser(String email, String token);

    List<User> selectUserList(LocalDateTime baseDateTime);
}
