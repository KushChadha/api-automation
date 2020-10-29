package com.wilson.aes.season;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wilson.aes.base.BaseTest;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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
		.when()
			.get()
		.then()
			.statusCode(200)
			.and().extract().response();
		
		System.out.println(response.prettyPrint());
	}

}
