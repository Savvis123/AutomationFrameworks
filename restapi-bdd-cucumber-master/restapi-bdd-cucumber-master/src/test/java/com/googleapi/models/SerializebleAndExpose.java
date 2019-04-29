package com.googleapi.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializebleAndExpose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gson gson=new Gson();
		
		Employee emp=new Employee("Mahesh", 20, "mahesh@gmail.com", "mahesh");
		String json=gson.toJson(emp);
		System.out.println(json);
		
		
		Gson gson1=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		String  josn1=gson1.toJson(emp);
		
		System.out.println(josn1);
		

	}

}
