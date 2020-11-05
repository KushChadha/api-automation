package com.wilson.aes.base;

import org.testng.annotations.BeforeClass;

import com.wilsom.aes.utilities.PropertiesUtils;
import com.wilson.aes.auth.Auth;

import io.restassured.RestAssured;

public class BaseTest {
	
	Auth auth = new Auth();
	PropertiesUtils properties = new PropertiesUtils();
	public String accessToken;
	
	@BeforeClass
	public void setup() {
		properties.loadProperties();
		RestAssured.baseURI = properties.getProperty("baseURI");
		RestAssured.basePath = properties.getProperty("basePath");
		accessToken = auth.getAuthToken();
	}

}
