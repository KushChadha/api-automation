package com.wilson.aes.base;

import org.testng.annotations.BeforeClass;

import com.wilsom.aes.utilities.PropertiesUtils;
import com.wilson.aes.auth.Auth;

import io.restassured.RestAssured;

public class BaseTest {
	
	public PropertiesUtils prop = new PropertiesUtils();
	public String accessToken;
	
	@BeforeClass
	public void setup() {
		prop.loadProperties();
		RestAssured.baseURI = prop.getProperty("baseURI");
		RestAssured.basePath = prop.getProperty("basePath");
		accessToken = Auth.getAuthToken();
	}

}
