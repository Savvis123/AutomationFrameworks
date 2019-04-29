package TestFramework;

public class Payload {
	
	public static String addemployee()
	{
		String payload= "{\r\n\r\n    \"id\": 21,\r\n    \"title\": \"json-server12\",\r\n    \"author\": \"typicode13\"\r\n  }\r\n";;
		
		return payload;
	}
	
	public static String addemployeetest(String id, String title, String author)
	{
		String payload= "{\r\n\r\n    \"id\": "+id+",\r\n    \"title\": \""+title+"\",\r\n    \"author\": \""+author+"\"\r\n  }\r\n";;
		
		return payload;
	}

}
