package com.api.tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;


import com.api.endpoints.StoreEndPoints;
import com.api.payloads.Store;
import com.api.utilities.dataProviders;

import io.restassured.response.Response;

public class StoreOrderTest {

	Store storePayload;

	public Logger logger;

	@BeforeTest
	public void init() {

		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority=1, dataProvider="StoreOrder", dataProviderClass = dataProviders.class)
	public void testCreateOrder(String id, String petId,String quantity, String shipDate, String status, String complete) {


		logger.info("****** Store Order Created *******");
		storePayload = new Store();

		storePayload.setId(Integer.parseInt(id));
		storePayload.setPetId(Integer.parseInt(petId));
		storePayload.setQuantity(Integer.parseInt(petId));
		storePayload.setShipDate(shipDate);
		storePayload.setStatus(status);
		storePayload.setComplete(Boolean.parseBoolean(complete));

		Response response = StoreEndPoints.createStoreOrder(storePayload);
		response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("****** Order Created *******");

	}



	@Test(priority=2, dataProvider="orderId", dataProviderClass = dataProviders.class)
	public void testGetOrder(String id) {

		logger.info("****** Retrieving order *******");
		Response response = StoreEndPoints.getOrder(Integer.parseInt(id));
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("****** Order is Retrieved *******");
	}

}

