package techmail.domain.mail.view;

import java.util.Map;

public interface MailView {
    String render(Map<Object, Object> attribute);

    String getType();
}
