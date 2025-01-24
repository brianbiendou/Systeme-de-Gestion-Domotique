package fr.insa.mas.ActionFen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.insa.mas.ActionFen.model.ActionFen;
import fr.insa.mas.ActionFen.resource.ActionFenController;
import fr.insa.mas.ActionFen.resource.ActionFenService;

@SpringBootTest
class ActionneurApplicationTests {

	@Test
	void testCreate() {
		ActionFen acTest = new ActionFen();
		assert(!acTest.isFenetreOuverte());
		acTest.setFenetreOuverte(true);;
		assert(acTest.isFenetreOuverte());
	}

	@Test
	void testController() {
		ActionFenService actionFenServiceTest = new ActionFenService();
		assert(!actionFenServiceTest.getActionneurState());
		ActionFenController control = new ActionFenController(actionFenServiceTest);
		assert(!control.getEtat());
		control.updateFenetre(true);
		assert(actionFenServiceTest.getActionneurState());
		assert(control.getEtat());
	}
}
