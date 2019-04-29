package TestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


//rahulonlinetutor@gmail.com
//https://mvnrepository.com/artifact/com.github.scribejava/scribejava-core/2.5.3

//https://mvnrepository.com/artifact/com.github.scribejava/scribejava-apis/2.5.3

public class OauthFromUdemy {

	String ConsumerKey="2xgskGYjU2WqhEOrjJxXdwE0w";
	String ConsumerSecret="GTWwDiE3CKM6hVeMGEvtiIoxxKVCGb7tcPWMdHWOzJMd55MblT";
	String Token="1070934540976148480-xwRzmo8DyEbBZ3ApdfIHPuNQEvESgB";
	String TokenSecret="cJwRkeS2XBaCDgzDwaHE6GktrYPT7fXmZR4CnfyLGPZHA";
	String id;
	@Test
	public void getLatestTweet()
	{
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
	Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
		.queryParam("count", "1")
		.when().get("/home_timeline.json").then().extract().response();
	
	String response =res.asString();
	System.out.println(response);
	JsonPath js= new JsonPath(response);
	
	System.out.println(js.get("text"));
	System.out.println(js.get("id"));
	
	
	}
	@Test
	public void createTweet()
	{
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
	Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
		.queryParam("status", "I am creating this tweet with Automation guru")
		.when().post("/update.json").then().extract().response();
	
	String response =res.asString();
	System.out.println(response);
	JsonPath js= new JsonPath(response);
	System.out.println("Below is the tweet added");
	//System.out.println(js.get("text"));
	System.out.println(js.get("id"));
	id=js.get("id").toString();
	
	
	}
	@Test
	public void E2E()
	{
		createTweet();
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
	     Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
		.when().post("/destroy/"+id+".json").then().extract().response();
	
	String response =res.asString();
	System.out.println(response);
	JsonPath js= new JsonPath(response);
	//System.out.println(js.get("text"));
	System.out.println("Tweet which got deleted with automation is below");
	System.out.println(js.get("text"));
	System.out.println(js.get("truncated"));
	
	
	}
	
	
}


