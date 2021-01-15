package com.wilson.aes.auth;

import static io.restassured.RestAssured.given;

import com.wilsom.aes.utilities.PropertiesUtils;

import io.restassured.response.Response;

public class Auth {
	
	public static PropertiesUtils properties = new PropertiesUtils();
	private static String authToken;

	private static void postAuthToken() {
		properties.loadProperties();
		String uri = properties.getProperty("authURI");
		String userName = properties.getProperty("authUserName");
		String password = properties.getProperty("authPassword");
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
	
	
	public static String getAuthToken() {
		postAuthToken();
		return authToken;
	}
}
