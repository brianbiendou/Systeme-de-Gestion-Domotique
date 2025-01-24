package fr.insa.mas.ActionAlarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActionAlarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionAlarmApplication.class, args);
	}

}
