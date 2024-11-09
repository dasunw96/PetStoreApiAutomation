package com.api.endpoints;

import static io.restassured.RestAssured.*;

import com.api.payloads.Store;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response createStoreOrder(Store payload){
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_store_order);
		
		return response;
	}
	
	public static Response getOrder(int orderId){
		
		Response response = given()
				.pathParam("orderId", orderId)
		.when()
			.get(Routes.get_store_order);
		
		return response;
	}	
	
	public static Response deleteOrder(int orderId){
		
		Response response = given()
				.pathParam("orderId", orderId)
		.when()
			.delete(Routes.delete_store_order);
		
		return response;
	}

}
