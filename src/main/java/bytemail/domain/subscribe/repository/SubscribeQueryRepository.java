package bytemail.domain.subscribe.repository;

import java.util.List;

public interface SubscribeQueryRepository{
    List<String> findEmails();
}
