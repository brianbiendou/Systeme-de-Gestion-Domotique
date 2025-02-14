package fr.insa.mas.presence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PresenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PresenceApplication.class, args);
	}

}
