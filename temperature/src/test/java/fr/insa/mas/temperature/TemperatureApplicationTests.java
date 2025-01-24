package fr.insa.mas.temperature;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.insa.mas.temperature.model.Temperature;
import fr.insa.mas.temperature.resource.TemperatureController;
import fr.insa.mas.temperature.resource.TemperatureService;

@SpringBootTest
class TemperatureApplicationTests {

	@Test
	void testCreate() {
		Temperature tempTest = new Temperature();
		tempTest.setExternalTemperature(0);
		tempTest.setInternalTemperature(20);
		LocalDateTime time = LocalDateTime.now();
		tempTest.setTimestamp(time);
		assert(tempTest.getExternalTemperature()==0);
		assert(tempTest.getInternalTemperature()==20);
		assert(tempTest.getTimestamp().isEqual(time));
		
	}

	@Test
	void testService() {
		TemperatureService tempServiceTest = new TemperatureService();
		tempServiceTest.getCurrentTemperature().setExternalTemperature(0);
		tempServiceTest.getCurrentTemperature().setInternalTemperature(10);
		LocalDateTime time = LocalDateTime.now();
		tempServiceTest.getCurrentTemperature().setTimestamp(time);
		assert(tempServiceTest.getCurrentTemperature().getExternalTemperature()==0);
		assert(tempServiceTest.getCurrentTemperature().getInternalTemperature()==10);
		assert(tempServiceTest.getCurrentTemperature().getTimestamp().isEqual(time));
	}
	
	@Test
	void testController() {
		TemperatureController control = new TemperatureController();
		control.updateExternalTemperature(15);
		control.updateInternalTemperature(7);
		assert(control.getExternalTemperature()==15);
		assert(control.getInternalTemperature()==7);
		assert(control.getLatestTemperature().getExternalTemperature() == control.getExternalTemperature());
	}
}
