package Day3;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class Headers {
	
			
//	@Test
		
		void testheaders()
		{
			given()
			
			
			.when()
			   .get("https://www.facebook.com/")
			
	     	.then()
        	.header("Content-Type", "application/json")
		    .and()
		    .header("Accept-Encoding", "gzip, deflate, br");
		//	.log().all();
		}
		
      @Test
		
		void getheaders()
		{
			Response res=given()
					
					.when()
					.get("https://www.facebook.com/");
			
			//get single header info
			
		//	String headervalue=res.getHeader("Content-Type");
		//	System.out.println("The value of content type header"+headervalue);
			
			
			//Get all header info
			Headers myheaders=res.getHeaders();
			
			for(Header hd:myheaders)
			{
				System.out.println(hd.getName()+"    "+hd.getValue());
			}
			
			
		
		}


}
