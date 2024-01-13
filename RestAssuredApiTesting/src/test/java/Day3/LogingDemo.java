package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LogingDemo {

	@Test
	void testLogs()
	
	{
		given()
		
		.when()
		.get("https://www.facebook.com/")
		
		.then()
		//.log().body();
		//.log().cookies();
		 .log().headers();
	}}
