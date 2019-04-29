package TestCases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;

public class OAuthTest {
	
	String consumerkey="2xgskGYjU2WqhEOrjJxXdwE0w";
	String consumersecretkey ="GTWwDiE3CKM6hVeMGEvtiIoxxKVCGb7tcPWMdHWOzJMd55MblT";
	String accesstoken="1070934540976148480-xwRzmo8DyEbBZ3ApdfIHPuNQEvESgB";
	String accesssecrettoken="cJwRkeS2XBaCDgzDwaHE6GktrYPT7fXmZR4CnfyLGPZHA";
	String Id;
	
	  @Test
	    public void getLatestTweets()
	    {
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		
		Response res=given().auth().oauth(consumerkey, consumersecretkey, accesstoken, accesssecrettoken).queryParam("count","1").
		when().get("/home_timeline.json").then().extract().response();
		
		String response=res.asString();
		JsonPath js=new JsonPath(response);
		System.out.println(js.get("text"));
		System.out.println(js.get("id"));
		
	   }

	  @Test
	  public void createTweet()
	  {
			RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
			
			Response res=given().auth().oauth(consumerkey, consumersecretkey, accesstoken, accesssecrettoken)
					        .queryParam("status","I am good ").
			                 when()
			                 .post("/update.json")
			                 .then().extract().response();
			
			String response=res.asString();
			
			JsonPath js=new JsonPath(response);
			//System.out.println(js.get("text"));
			
			
			System.out.println("Below is the tweet added");
			System.out.println(js.get("id"));
			Id=js.get("id").toString();
			
		   }
	  
	  @Test
	  public void deleteTweet()
	  {
		  createTweet();
		  
			RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
			
			Response res=given().auth().oauth(consumerkey, consumersecretkey, accesstoken, accesssecrettoken)
					        
			                 .when().post("/destroy/"+Id+".json")
			                 .then().extract().response();
			
			String response =res.asString();
			//System.out.println(response);
			JsonPath js= new JsonPath(response);
			//System.out.println(js.get("text"));
			System.out.println("Tweet which got deleted with automation is below");
			System.out.println(js.get("text"));
			System.out.println(js.get("truncated"));
			
		   }
}
