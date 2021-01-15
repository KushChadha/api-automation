package com.wilsom.aes.utilities;

import com.wilson.aes.auth.Auth;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestUtilities {

	public static String ENDPOINT;
	public static RequestSpecBuilder reqSpecBuilder;
	public static RequestSpecification reqSpec;
	public static ResponseSpecBuilder respSpecBuilder;
	public static ResponseSpecification respSpec;
	
	
	public static void setEndpoint(String endPoint) {
		ENDPOINT = endPoint;
	}
	
	public static RequestSpecification getRequestSpecification() {
		AuthenticationScheme auth = RestAssured.oauth2(Auth.getAuthToken());
		reqSpecBuilder = new RequestSpecBuilder();
		reqSpecBuilder.setRelaxedHTTPSValidation();
		reqSpecBuilder.setAuth(auth);
		reqSpec = reqSpecBuilder.build();
		return reqSpec;
	}
	
	public static ResponseSpecification getResponseSpecification() {
		respSpecBuilder = new ResponseSpecBuilder();
		respSpec = respSpecBuilder.build();
		return respSpec;
	}
	
//	public static 
	
	
	
}
