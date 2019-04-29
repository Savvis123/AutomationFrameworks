package com.googleapi.models;

import com.google.gson.annotations.Expose;

public class Employee {
	
	private String firstname;
	
	@Expose(deserialize=false)
	private int age;
	
	@Expose
	private String mail;
	
	@Expose(serialize=false)
	private String password;
	
	public Employee(String firstname,int age,String mail,String password)
	{
		this.firstname=firstname;
		this.age=age;
		this.mail=mail;
		this.password=password;
	}
	

}
