package TestFramework;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class createjsonfromhashmap {
	
	@Test
	public void addemployee()
	{
		Map<String,Object> jsonasmap=new HashMap<String ,Object>();
		jsonasmap.put("id", 456);
		jsonasmap.put("title", "hashmapconcept");
		jsonasmap.put("author", "Mahesh");
		
		RestAssured.baseURI="http://localhost:3000";

		Response resp= given().

		header("Content-Type","application/json").

		body(jsonasmap).

		when().

		post("/posts").

		then().assertThat().statusCode(201).

		extract().response();

		JsonPath js= ReusableMethods.rawToJson(resp);

		   String id=js.get("ID");

		   System.out.println(id);

		
		
	}

}
