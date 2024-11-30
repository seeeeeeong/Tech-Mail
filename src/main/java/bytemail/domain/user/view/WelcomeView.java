package bytemail.domain.user.view;

import bytemail.domain.mail.view.MailView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class WelcomeView implements MailView {

    private final SpringTemplateEngine templateEngine;

    @Override
    public String render(Map<Object, Object> attribute) {
        Context context = new Context();
        return templateEngine.process("welcome", context);
    }

    @Override
    public String getType() {
        return "welcome";
    }
}
