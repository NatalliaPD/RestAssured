package testCases;



	import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
	
	
	public class Create_A_Product {

		
		@Test
		
		public void create_a_product() {
			
			//http://techfios.com/api-prod/api/product/create.php
			 
			HashMap payload = new HashMap();
			payload.put("name", "AI Robot Sofiya");
			payload.put("description", "Super smart robot");
			payload.put("price", "100000");
			payload.put("category_name", "Electronics");
			payload.put("category_id", "2");
			
		//	RestAssured.baseURI = ("https://techfios.com");
			
			
		Response response =
	    given()
			.baseUri("https://techfios.com")
				.body(payload)
		       .header("Content-Type", "application/json")
		       .when()
		       .post("/api-prod/api/product/create.php")
	    .then()
			.extract().response();
			
			// Validating response status
			
//			int responseStatus = response.getStatusCode();
//			System.out.println("Response Status:" + responseStatus);
//			Assert.assertEquals(responseStatus, 200);
//			
			//Validating response header
			
//			String responseHeader = response.getHeader("Content-Type");
//			System.out.println(responseHeader);
//			Assert.assertEquals(responseHeader, "application/json");
			
//			//Validate product name and other parameters
		String ResponseBody = response.getBody().asString();
		JsonPath js = new JsonPath(ResponseBody);
		System.out.println(ResponseBody);
		String message = js.getString("message");
		Assert.assertEquals(js.get("message"), "Product was created.");
		
//		
//		String productName = js.get("name"); 
//		String productDescription = js.get("description"); 
//		String productPrice = js.get("price"); 
		
//		Assert.assertEquals(productName, "Vacuum Cleaner Nata-Pro 2.21");
//		Assert.assertEquals(productDescription, "AI helper");
//		Assert.assertEquals(productPrice, "1199");
//		
//		System.out.print(productName + "\n" + productDescription + "\n" + productPrice + "\n");
//		
//		// Assert.assertEquals(ResponseBody,"application/json");
//	  
//  
			 
		}

		
}
