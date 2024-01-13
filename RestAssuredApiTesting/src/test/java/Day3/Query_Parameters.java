package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;//package important is must withought of thus we donot move forward
public class Query_Parameters {

	
	//https://reqres/api/users?page=2&id=5


	@Test
	void testQueryAndPathParameters(){
		
		given()
		 .pathParam("mypath","users")  //path parameters
		 .queryParam("page","2")   //Query param
		 .queryParam("id","5")   //Query param
		 
		.when()
		   .get("https://reqres/api/{mypath}")//  mypath is pathparam
		   
		
		
		.then()
	        .statusCode(200)
		    .log().all();
		
	}
}
