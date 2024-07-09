package com.api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.endpoints.UserEndPoints;
import com.api.payloads.User;
import com.api.utilities.dataProviders;

import io.restassured.response.Response;

public class UserTest {
	
	User userPayload;
	
	public Logger logger;
	
	@BeforeTest
	public void init() {
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1, dataProvider="Data", dataProviderClass = dataProviders.class)
	public void testCreateUser(String userId, String userName,String fName, String lName, String email, String pwd, String ph) {
		
		
		logger.info("****** Creating User *******");
		userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****** User is Created *******");
		
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass = dataProviders.class)
	public void testGetUser(String userName) {
		
		Response response = UserEndPoints.getUser(userName);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=3, dataProvider="UserNames", dataProviderClass=dataProviders.class)
	public void testDeleteUser(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	

}
