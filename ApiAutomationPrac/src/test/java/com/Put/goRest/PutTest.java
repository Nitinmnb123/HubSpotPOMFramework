package com.Put.goRest;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class PutTest {
	
	
	@Test
	public void put_GoRestTest()
	{
		
		//create a user post
		Users_Pojo user=new Users_Pojo("Pradhnya","jaggam","female","14-08-1996","jaggam@gmail.com");
		
		ObjectMapper mapper=new ObjectMapper();
		
		String UserJSon=null;;
		try {
			UserJSon = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(UserJSon);
		RestAssured.given().log().all()
		 .contentType(ContentType.JSON)
		 .header("Authorization","Bearer CLEPEMk44XYLgLwIDDWB6JAdc290OnaAcj3Y")
		 .body(UserJSon)
		 .when().log().all()
		 .post("https://gorest.co.in/public-api/users")
		 .then().log().all()
		   .assertThat()
		   .statusCode(200);
		
		
	
		
		
		
	}

}
