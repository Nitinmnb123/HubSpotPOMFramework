package com.GetApi;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetBDD {

	@Test
	public void getCircuitTest_1() {

		given().log().all().when().log().all().get("http://ergast.com/api/f1/2010/circuits.json");
	}

	@Test
	public void getCircuitListTest_2() {
		given().when().get("http://ergast.com/api/f1/2010/circuits.json").then().assertThat().body("MRData.total",
				equalTo("19"));
	}

	@Test
	/*public void getCircuitListTest_contentLength() {
		RestAssured.baseURI = "http://ergast.com";

		given().log().all().when().log().all().get().then().log().all().assertThat()
				.statusCode(200).and().contentType("application/json").and().header("Content-Length", equalTo("4350"));

	}
*/
	@DataProvider(name="getcircuitlist")
	public Object[][] getCircuitList()
	{
		 return new Object [] [] {
			{"2016",21},
			{"2010",19},
		};
	}
	
	@Test(dataProvider ="getcircuitlist" )
	public void getCircuitListTest(String YearName,int noOfCircuit)
	{
		RestAssured.baseURI="http://ergast.com";
		given().log().all()
		  .pathParam("Currentyear", YearName)
		.when().log().all()
		 .get("/api/f1/{Currentyear}/circuits.json")
		  .then().log().all()
		    .assertThat()
		    .body("MRData.CircuitTable.Circuits.circuitId", hasSize(noOfCircuit));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
