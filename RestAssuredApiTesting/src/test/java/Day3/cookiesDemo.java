package Day3;
import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
public class cookiesDemo {
	
//	@Test
	
	void testcookies()
	{
		given()
		
		
		.when()
		   .get("https://www.facebook.com/")
		
		.then()
	//	   .cookie("sb","DaIVYuxxF-hsk9vC2IRpD1_k")//values of cookies change everytime and while running script with cookies that value then fail the script
		   .log().all();
	}
	

	@Test
	
	void getcookiesInfo()
	{
   Response res= given()
		
		
		.when()
		   .get("https://www.facebook.com/");
		
		//Get single cookies info
	//	  String cookie_value=res.getCookie("sb");
		  
	//  System.out.println("Value of cookies======>"+cookie_value);
   
   
   //get all coookies info
  Map<String,String>Cookies_value= res.getCookies();
  
 // System.out.println(Cookies_value.keySet());
  
  for(String k:Cookies_value.keySet())
  {
	  
    String Cookies_value1=res.getCookie(k);
 System.out.println(k+"     "+Cookies_value1);
  }

	

}}
