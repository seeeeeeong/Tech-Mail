package bytemail.global.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/env")
    public String getEnv() {
        return activeProfile;
    }

}
