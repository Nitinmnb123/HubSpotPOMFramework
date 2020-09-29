package ResponseBuilder;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
public class ResponseBuilderTest
{
      public  ResponseSpecification ResponseBuilder()
      {
                 return new  ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build(); 
}
      
      @Test
      public void ResponseSpecTest()
      {
    	  RestAssured.baseURI="https://gorest.co.in/";
    	  given()
    	     .header("Authorization","Bearer CLEPEMk44XYLgLwIDDWB6JAdc290OnaAcj3Y")
    	    .when()
    	    .get("public-api/users")
    	    .then().assertThat().spec(ResponseBuilder());
    	  
      }
}
