package DAY4;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class PASSINGJSONRESPONSEDATA {

	@Test(priority=1)
	void testjsonresponse() {
		
		//Approach 1
		
/*		given()
		 .contentType("ContentType.JSON")
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		 .statusCode(200)
         .header("Content-Type", "application/json; charset=uft-8")
         .body("book[3].title",equalTo("The lord of the rings"));                 */
		
		
		//Approach 2
		
/*	Response res=given()
		 .contentType("ContentType.JSON")
		
		.when()
		.get("http://localhost:3000/store");  */
		
		//Assert.assertEquals(res.getStatusCode(),200);  //validation
     //   Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
        
   //    String bookname=res.jsonPath().get("book[3].title").toString();
     // Assert.assertEquals(bookname,"The lord of the rings");
	
	//JSONObject class             //Validation 1
		
		@Test(priority=1)
		void testjsonresponseBodyDATA() {
			
			//Approach 1
			
			Response res=given()
			 .contentType(ContentType.JSON)
			
			.when()
			.get("http://localhost:3000/store");
	
	JSONObject jo=new JSONObject(res.toString());
	boolean  status =false;
	for(int i=0;i<jo.getJSONArray("book").length();i++)
	{
		String booktitle= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		if(booktitle.equals("The lord of the rings"))
		{
	   status=true;
	   break;
	}
			}
	Assert.assertEquals(status, true);
	
	//Validate the total  price of books  -validation 2
	
	double totalprice=0;
	for(int i=0;i<jo.getJSONArray("book").length();i++)
	{
		String price= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		totalprice=totalprice+Double.parseDouble(price);
		}
	
	System.out.println("Total price of the book is "+ totalprice);
	Assert.assertEquals(totalprice, 53.92); 
	
}}
