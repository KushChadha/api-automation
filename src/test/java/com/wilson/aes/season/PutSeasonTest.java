package com.wilson.aes.season;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.wilson.aes.base.BaseTest;
import com.wilson.aes.models.PutSeasonModel;

public class PutSeasonTest extends BaseTest {
	
	PutSeasonModel seasonModel = new PutSeasonModel();
	Map<String, String> metadata = new HashMap<String, String>();
	
	@Test
	public void putSeason() {
		metadata.put("modifiedTime", "2020-01-16T00:00:00-07:00");
		
		seasonModel.setConcept("pb");
		seasonModel.setId("testSeason");
		seasonModel.setName("test season");
		seasonModel.setStatus("active");
		seasonModel.setMetadata(metadata);
		
		given()
			.auth().oauth2(accessToken)
			.body(seasonModel)
		.when()
			.post("/testSeason")
		.then()
			.statusCode(200);
		
	}

}
