package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyResponseUsingJsonpath {
	
	@Test
	public void validateResponseWithJson()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest=RestAssured.given();
		Response res=httprequest.when().get("/Hyderabad");
		System.out.println("response is :"+res.asString());
		
		JsonPath js=res.jsonPath();
		
		System.out.println("city received from response:"+js.get("City"));
		
		
	}

}
