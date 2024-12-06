package techmail.domain.user.view;

import techmail.domain.mail.view.MailView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class VerifyCodeView implements MailView {

    private final SpringTemplateEngine springTemplateEngine;

    @Override
    public String render(Map<Object, Object> attribute) {
        Context context = new Context();
        context.setVariable("code", attribute.get("code"));

        return springTemplateEngine.process("verify", context);
    }

    @Override
    public String getType() {
        return "verify";
    }
}
