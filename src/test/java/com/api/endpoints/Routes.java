package com.api.endpoints;

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	// user module
	
	public static String post_user = base_url + "/user";
	public static String get_user = base_url + "/user/{username}";
	public static String update_user = base_url + "/user/{username}";
	public static String delete_user = base_url + "/user/{username}";
	
	// Store module
	
	public static String post_store_order = base_url + "/store/order";
	public static String get_store_order = base_url + "/store/order/{orderId}";
	public static String delete_store_order = base_url + "/store/order/{orderId}";
	
	
	// Pet module
	 
	public static String post_pet = base_url + "/pet";
	public static String post_pet_image = base_url + "/pet/{petId}/uploadImage";
	public static String get_pet_by_id = base_url + "/pet/{petId}";
	public static String get_pet_by_status = base_url + "/pet/findByStatus";
	public static String update_pet = base_url + "/pet";
	public static String delete_pet = base_url + "/pet/{petId}";
	

}
