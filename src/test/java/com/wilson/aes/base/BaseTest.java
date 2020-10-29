package com.wilson.aes.base;

import org.testng.annotations.BeforeClass;

import com.wilson.aes.auth.Auth;

import io.restassured.RestAssured;

public class BaseTest {
	
	Auth auth = new Auth();
	public String accessToken;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://ecommerce-assortment-export-qa.services.west.nonprod.wsgc.com";
		RestAssured.basePath = "/assortment/v1/pb/seasons";
		accessToken = auth.getAuthToken();
	}

}
