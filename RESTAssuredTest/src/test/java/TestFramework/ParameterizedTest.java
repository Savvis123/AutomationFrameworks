package TestFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ParameterizedTest {
	
	
	//@Test
	public void addNewEmployee()
	{
		RestAssured.baseURI="http://localhost:3000";

		Response resp= given().

		header("Content-Type","application/json").

		body(Payload.addemployee()).

		when().

		post("/posts").

		then().assertThat().statusCode(201).

		extract().response();

		JsonPath js= ReusableMethods.rawToJson(resp);

		   String id=js.get("ID");

		   System.out.println(id);

		   

		   //deleteBOok

		}
	
	
	//@Test
	public void addNewEmployeeFromTest()
	{
		RestAssured.baseURI="http://localhost:3000";

		Response resp= given().

		header("Content-Type","application/json").

		body(Payload.addemployeetest("123","Mahesh","suresh")).

		when().

		post("/posts").

		then().assertThat().statusCode(201).

		extract().response();

		JsonPath js= ReusableMethods.rawToJson(resp);

		   String id=js.get("ID");

		   System.out.println(id);

		   

		   //deleteBOok

		}
	
	
	@Test(dataProvider="EmployeeData")
	public void addNewEmployeeFromTestNG(String id,String title,String author)
	{
		RestAssured.baseURI="http://localhost:3000";

		Response resp= given().

		header("Content-Type","application/json").

		body(Payload.addemployeetest(id,title,author)).

		when().

		post("/posts").

		then().assertThat().statusCode(201).

		extract().response();

		JsonPath js= ReusableMethods.rawToJson(resp);

		   String id1=js.get("ID");

		   System.out.println(id1);

		   

		   //deleteBOok

		}


		@DataProvider(name="EmployeeData")
        public Object[][]  getData()
        {

		//array=collection of elements

		//multidimensional array= collection of arrays
			
			return new Object[][] {{"4","A","B"},{"5","C","D"}, {"6","E","F"}};

       }
	

		}
