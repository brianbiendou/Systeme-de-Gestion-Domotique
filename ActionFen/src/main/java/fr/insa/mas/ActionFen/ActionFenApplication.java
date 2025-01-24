package fr.insa.mas.ActionFen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActionFenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionFenApplication.class, args);
	}

}
