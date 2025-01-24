package fr.insa.mas.Gestionnaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireApplication.class, args);
	}

}
