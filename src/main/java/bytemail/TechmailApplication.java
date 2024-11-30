package bytemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TechmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechmailApplication.class, args);
	}

}
