package com.api.endpoints;

import static io.restassured.RestAssured.*;

import com.api.payloads.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response createUser(User payload){
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_user);
		
		return response;
	}
	
	public static Response getUser(String userName){
		
		Response response = given()
				.pathParam("username", userName)
		.when()
			.get(Routes.get_user);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(Routes.update_user);
		
		return response;
	}
	
	public static Response deleteUser(String userName){
		
		Response response = given()
				.pathParam("username", userName)
		.when()
			.delete(Routes.delete_user);
		
		return response;
	}

}
