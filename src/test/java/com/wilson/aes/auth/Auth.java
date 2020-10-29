package com.wilson.aes.auth;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class Auth {
	
	private String authToken;

	private void postAuthToken() {
		Response res = 
			given()
				.relaxedHTTPSValidation()
				.auth()
				.basic("wcm/QA", "wcm4qa")
				.param("grant_type", "client_credentials")
			.when()
				.post("https://webauth-qa-rk01v.wsgc.com/oauth/token")
			.then()
				.statusCode(200)
				.extract().response();
		
		authToken = res.path("access_token");
	}
	
	
	public String getAuthToken() {
		postAuthToken();
		return authToken;
	}
}