package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Put_Update_A_Product {

	

	SoftAssert softAssert = new SoftAssert();
	Put_Update_A_Product readAProd = new Put_Update_A_Product();
	
	@Test
	
	public void Update_A_Product() {
		
		//http://techfios.com/api-prod/api/product/update.php
		 
		HashMap payload = new HashMap();
		payload.put("id", "1203");
		payload.put("name", "i Phone 12 pro max");
		payload.put("description", "Pretty good phone");
		payload.put("price", "1299");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
		
		
	//	RestAssured.baseURI = ("https://techfios.com");
		
		
	Response response =
    given()
		.baseUri("https://techfios.com")
	       .header("Content-Type", "application/json; charset UTF-8")
	       .body(payload)
	       .when() 
	       .put("/api-prod/api/product/update.php")
    .then()
		.extract().response();
	
	
		// Validating response status
		
//		int responseStatus = response.getStatusCode();
//		System.out.println("Response Status:" + responseStatus);
//		Assert.assertEquals(responseStatus, 200);
//		
		//Validating response header
		
//		String responseHeader = response.getHeader("Content-Type");
//		System.out.println(responseHeader);
//		Assert.assertEquals(responseHeader, "application/json");
		
//		//Validate product name and other parameters
	String ResponseBody = response.getBody().asString();
	
	JsonPath js = new JsonPath(ResponseBody);
	
	System.out.println(ResponseBody);
	
	String message = js.getString("message");
	
	Assert.assertEquals(js.get("message"), "Product was updated.", "Not matching the assertions!!!");
	
	readAProd.Update_A_Product();
	
	softAssert.assertAll();
//	
//	String productName = js.get("name"); 
//	String productDescription = js.get("description"); 
//	String productPrice = js.get("price"); 
	
//	Assert.assertEquals(productName, "Vacuum Cleaner Nata-Pro 2.21");
//	Assert.assertEquals(productDescription, "AI helper");
//	Assert.assertEquals(productPrice, "1199");
//	
//	System.out.print(productName + "\n" + productDescription + "\n" + productPrice + "\n");
//	
//	// Assert.assertEquals(ResponseBody,"application/json");
//  
//
		 
	}

	

	}



