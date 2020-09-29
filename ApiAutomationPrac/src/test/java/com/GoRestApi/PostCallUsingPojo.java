package com.GoRestApi;
import JsonUtil.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;


public class PostCallUsingPojo 
{

	@Test
	public void createUser_Pojo_Test()
	{
		Users user=new Users("Nitin","Kumar","Male","14-07-1992","nishu@gmail.com");
		
		ObjectMapper mapper=new ObjectMapper(); 
		String UserJson=null;
		try {
			UserJson=mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(UserJson);
		
		
	}
	
}
