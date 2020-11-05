package com.wilson.aes.auth;

import static io.restassured.RestAssured.given;

import com.wilsom.aes.utilities.PropertiesUtils;

import io.restassured.response.Response;

public class Auth {
	
	PropertiesUtils properties = new PropertiesUtils();
	private String authToken;

	private void postAuthToken() {
		properties.loadProperties();
		String uri = properties.getProperty("authURI");
		String userName = properties.getProperty("authUserName");
		String password = properties.getProperty("authPassword");
		System.out.println("user name is " + uri);
		Response res = 
			given()
				.relaxedHTTPSValidation()
				.auth()
				.basic(userName, password)
				.param("grant_type", "client_credentials")
			.when()
				.post(uri)
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
