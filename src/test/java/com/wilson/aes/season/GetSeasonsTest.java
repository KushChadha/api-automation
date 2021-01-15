package com.wilson.aes.season;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import com.wilsom.aes.utilities.RestUtilities;
import com.wilson.aes.base.BaseTest;
import com.wilson.aes.constants.EndPoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSeasonsTest extends BaseTest{
	
//	String accessToken = "c1enItEGsyTW0YvcDtd1FkFl";
	
	/*@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://ecommerce-assortment-export-qa.services.west.nonprod.wsgc.com";
		RestAssured.basePath = "/assortment/v1/pb/seasons";
	}*/
	
	@Test
	public void getSeasons() {
		Response response = 
		given()
			.relaxedHTTPSValidation()
			.auth().oauth2(accessToken)
			.pathParam("concept_code", prop.getProperty("concept_code"))
		.when()
			.get(EndPoints.SEASONS)
		.then()
			.statusCode(200)
			.and().extract().response();
		
		System.out.println(response.prettyPrint());
	}
	
//	RequestSpecBuilder requestBuilder;
//	RequestSpecification requestSpec;
	
	@Test
	public void getSeasonsUsingRequestSpecifications() {
		RestUtilities.getRequestSpecification();
		
		
	}

}
