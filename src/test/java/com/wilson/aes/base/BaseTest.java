package com.wilson.aes.base;

import org.testng.annotations.BeforeClass;

import com.wilson.aes.auth.Auth;

import io.restassured.RestAssured;

public class BaseTest {
	
	Auth auth = new Auth();
	public String accessToken;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "";
		RestAssured.basePath = "";
		accessToken = auth.getAuthToken();
	}

}
