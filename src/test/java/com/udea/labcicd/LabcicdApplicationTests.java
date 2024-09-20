package com.udea.labcicd;

import com.fasterxml.jackson.databind.JsonNode;
import com.udea.labcicd.Controller.DataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LabcicdApplicationTests {

	@Autowired
	DataController dataController;

	@Test
	void healthCheck() {
		assert(dataController.healthCheck().equals("PROYECTO DE LABORATORIO DE CI/CD"));
	}

	@Test
	void version() {
		assert(dataController.version().equals("1.0.0"));
	}

	@Test
	void nationsLenght() {
		assert(dataController.getRadomNation().size() == 10);
	}

	@Test
	void currenciesLenght() {
		assert(dataController.getRadomCurrencies().size() == 20);
	}

	@Test
	void randomCurrenciesCodeFormat() {
		DataController controller = new DataController();
		JsonNode response = controller.getRadomCurrencies();
		for (JsonNode node : response) {
			assert(node.get("code").asText().length() == 3);
		}
	}

	@Test
	void randomNationsPerformance() {
		DataController controller = new DataController();
		long start = System.currentTimeMillis();
		controller.getRadomNation();
		long end = System.currentTimeMillis();
		assert (end - start < 1000);
	}

	@Test
	void aviationLength() {
		assert(dataController.getRadomAviation().size() == 20);
	}


}
