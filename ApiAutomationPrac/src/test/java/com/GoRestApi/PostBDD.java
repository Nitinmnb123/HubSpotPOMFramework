package com.GoRestApi;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PostBDD {

	@Test
	public void postCallBddApproach_Test()
	{
		RestAssured.baseURI="https://gorest.co.in";
		
		given().log().all()
           .header("Authorization","Bearer CLEPEMk44XYLgLwIDDWB6JAdc290OnaAcj3Y")	
           .contentType(ContentType.JSON)
           .body(new  File("C:\\Users\\Aditya\\Desktop\\ApiautomationPractice"
           		+ "\\ApiAutomationPrac\\src\\test\\java\\JsonUtil\\User.json"))
           .when().log().all()
           .post("/public-api/users")
           .then().log().all()
           ;
	}
	
}
