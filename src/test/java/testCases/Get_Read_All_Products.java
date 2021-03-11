package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Get_Read_All_Products {
	
	
	@Test
	
	public void read_All_Products() {
	//reference variable that holds the following
		Response response = 
	given()
	.baseUri("https://techfios.com/api-prod/api/product")
	.header("Content-Type", "application/json; charset=UTF-8")
	
	.when().get("/read.php")
	
	.then()
	.statusCode(200)
	    .extract().response();
		
	int statusCode = response.getStatusCode();
	System.out.println("Status Code: " + statusCode);
	Assert.assertEquals(statusCode, 200);
	
	String responseBody = response.getBody().asString();
	System.out.println(responseBody);
	}
}
