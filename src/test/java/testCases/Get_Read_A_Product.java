package testCases;


	import org.testng.Assert;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

	import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
	public class Get_Read_A_Product {
	
		SoftAssert softAssert = new SoftAssert();
		
		@Test
		
		public void read_A_Products() {
		//reference variable that holds the following
			Response response = 
		given()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
		.queryParam("id", "1209")
		
	.when()
	    .get("/read_one.php")
		
	.then()
		
		    .extract().response();
			
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		
		//hard assert
		Assert.assertEquals(statusCode, 200);
		
		//soft assert
		//softAssert.assertEquals(statusCode, 201, statusCode + "statusCode is not matching with" + 201);
		
		//softAssert.assertEquals(statusCode, 201, "Not matching");
		
		//method that does pretty print
		//response.getBody().prettyPrint()
		
		String responseBody = response.getBody().asString();
		String responseContentType = response.header("Content - Type");
		softAssert.assertEquals(responseContentType, "application/json", "Header mismatch");
		
//		System.out.println("responseBody: " + responseBody);
	
		
		//Parsing responseBody to Json
		JsonPath js = new JsonPath(responseBody);
		
		String productID = js.getString("id");
		System.out.println(productID);
		
		String productName = js.getString("name");
		
		
		String productDescription = js.getString("description");
		
		Assert.assertEquals(productID, "1209");
		Assert.assertEquals(productName, "HP Laptop Elite Pro");
		Assert.assertEquals(productDescription, "Super fast laptop");
		
		softAssert.assertAll();
		
	//	js.prettyPrint();
	//	System.out.println(js);
		
		//validating reponse time
		
//		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
//		System.out.println("Response Time: " + responseTime);
//		
//		if(responseTime <= 2000) {
//			System.out.println("Response time is within the normal range");
//		}else {
//			System.out.println("Not acceptable");
//		}
		
		}
	}


