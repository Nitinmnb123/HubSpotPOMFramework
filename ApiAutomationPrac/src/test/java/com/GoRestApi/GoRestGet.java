package com.GoRestApi;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GoRestGet {

	@Test
	public void GetAllUsers_Oauth2() {
		RestAssured.given().log().all().auth().oauth2("CLEPEMk44XYLgLwIDDWB6JAdc290OnaAcj3Y").when()
				.get("https://gorest.co.in/public-api/users").then().log().all().assertThat().statusCode(200);
	}

	@Test
	public void GetSpecificUser_queryParam_oauth2() {
		RestAssured.given().queryParam("first_name", "Jessyca").log().all().auth()
				.oauth2("CLEPEMk44XYLgLwIDDWB6JAdc290OnaAcj3Y").when().get("https://gorest.co.in/public-api/users")
				.then().log().all().assertThat().statusCode(200).and().header("Server", "nginx")
				.and().body("result.dob", equalTo("1989-12-06"));
	}
}
