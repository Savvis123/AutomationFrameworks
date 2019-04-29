package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class GetAllBooks {
	
	@Test
	public void getAllBooksTest()
	{
		
		//ValidatableResponse res=given().when().get("http://localhost:8080/store").then().statusCode(200);
		// Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a GET request call directly by using RequestSpecification.get() method.
		 // Make sure you specify the resource name.
		 
		 Response response = httpRequest.when().get("/Hyderabad");
		 //Response response = httpRequest.get("/Hyderabad");
		 
		 // Response.asString method will directly return the content of the body
		 // as String.
		 System.out.println("Response Body is =>  " + response.asString());
		 
		 
		 //verify the status code
		 
		 int statuscode = response.statusCode();
		 Assert.assertEquals(statuscode, 200,"returned correct status code");
		 
		 //verify the status line 
		 
		 String statusline=response.statusLine();
		 Assert.assertEquals(statusline,"HTTP/1.1 200 OK","returned correct statusline");
		 
		 //get response body
		 ResponseBody body=response.getBody();
		 System.out.println(body);
		 
		 //verify header
		 String contenttype=response.getContentType();
		 Assert.assertEquals(contenttype, "application/json","returned correct header ");
		 
		 //get headers
		 Headers headers=response.getHeaders();
		 System.out.println(headers);
		 
		 for(Header header : headers)
		 {
		 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		 }
		}
		 
		
		 
         
	
	@Test
	public void verifyErrorCode()
	{
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest=RestAssured.given();
		Response res=httprequest.when().get("/hyderabad1");
		
		int errorstatuscode=res.getStatusCode();
		System.out.println(errorstatuscode);
		
		Assert.assertEquals(errorstatuscode, 400,"expected error code");
				
	}

}
