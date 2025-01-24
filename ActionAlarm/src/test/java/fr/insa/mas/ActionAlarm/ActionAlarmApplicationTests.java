package fr.insa.mas.ActionAlarm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.ActionAlarm.model.ActionAlarm;
import fr.insa.mas.ActionAlarm.resource.*;
@SpringBootTest
class ActionAlarmApplicationTests {

	@Test
	void testCreate() {
		ActionAlarm acTest = new ActionAlarm();
		assert(!acTest.isAlarm());
		acTest.setAlarm(true);
		assert(acTest.isAlarm());
		}

	@Test
	void testController() {
		ActionAlarmService actionalarmServiceTest = new ActionAlarmService();
		assert(!actionalarmServiceTest.getActionneurState());
		ActionAlarmController control = new ActionAlarmController(actionalarmServiceTest);
		assert(!control.getEtat());
		control.updateAlarm(true);
		assert(actionalarmServiceTest.getActionneurState());
		assert(control.getEtat());
	}
	
}
