package TestFramework;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

import org.testng.annotations.Test;

public class StaticJsonPayload {
	
	
	@Test
	public void addNewEmployee() throws IOException
	{
		RestAssured.baseURI="http://localhost:3000";

		Response resp= given().

		header("Content-Type","application/json").

		body(GenerateStringFromResource("C:\\Users\\ab64129\\Desktop\\REST\\RESTAssuredTest\\text.json")).

		when().

		post("/posts").

		then().assertThat().statusCode(201).

		extract().response();

		JsonPath js= ReusableMethods.rawToJson(resp);

		   String id=js.get("ID");

		   System.out.println(id);

		   

		   //deleteBOok

		}
	
	public static String GenerateStringFromResource(String path) throws IOException {
               return new String(Files.readAllBytes(Paths.get(path)));
       }
}
