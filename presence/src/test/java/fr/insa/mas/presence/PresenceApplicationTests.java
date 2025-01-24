package fr.insa.mas.presence;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.insa.mas.presence.model.*;
import fr.insa.mas.presence.resource.*;

@SpringBootTest
class PresenceApplicationTests {
	
	@Test
	void testCreate() {
		Presence prTest = new Presence(false,"10");
		assert(!prTest.isPresence());
		prTest.setPresence(true);
		assert(prTest.isPresence());
	}

	@Test
	void testController() {
		Presenceservice presServiceTest = new Presenceservice();
		assert(!presServiceTest.getCurrentPresence().isPresence());
		PresenceController control = new PresenceController(presServiceTest);
		assert(!control.getPresence().isPresence());
		control.updatePresence(true);
		assert(presServiceTest.getCurrentPresence().isPresence());
		assert(control.getPresence().isPresence());
	}
}
