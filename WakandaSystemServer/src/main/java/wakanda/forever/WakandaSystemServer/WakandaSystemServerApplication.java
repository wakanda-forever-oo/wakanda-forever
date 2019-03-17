package wakanda.forever.WakandaSystemServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WakandaSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WakandaSystemServerApplication.class, args);
	}

}
