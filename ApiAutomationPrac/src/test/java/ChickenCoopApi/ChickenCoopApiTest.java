package ChickenCoopApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChickenCoopApiTest {

	/*@Test
	public void Chickencoop_BarnunlockTest() {

		RequestSpecification request = RestAssured.given().auth().oauth2("70d0c889f88511ee02079681709cb6065c8923db");

		Response response = request.post("http://coop.apps.symfonycasts.com/api/1185/barn-unlock");

		response.then().assertThat().statusCode(200);
		System.out.println(response.prettyPrint());

	}
*/
	@Test
	public void ChickenCoop_GenerateTokenid() {

		RequestSpecification request = RestAssured.given().formParam("client_id", "ApiPract")
				.formParam("client_secret", "c89e8ab4a0faa5fe269b737c8f19476b")
				.formParam("grant_type", "client_credentials");

		Response response = request.post("http://coop.apps.symfonycasts.com/token");

		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());

		String tokenid = response.jsonPath().getString("access_token");

		System.out.println("Api Token Id is" + " " + tokenid);

		RequestSpecification request1 = RestAssured.given().auth().oauth2(tokenid);

		Response response1 = request1.post("http://coop.apps.symfonycasts.com/api/1185/barn-unlock");

		response1.then().assertThat().statusCode(200);
		System.out.println(response.prettyPrint());

	}
}
