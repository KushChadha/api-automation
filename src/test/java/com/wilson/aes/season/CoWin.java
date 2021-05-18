package com.wilson.aes.season;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CoWin {
	
	@Test
	public void request() {
		Response response = given()
		.when()
			.get("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=247001&date=22-05-2021")
		.then().extract().response();
		
		System.out.println(response);
	}

}
