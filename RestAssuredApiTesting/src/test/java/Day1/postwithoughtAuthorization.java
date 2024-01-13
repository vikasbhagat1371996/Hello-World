package Day1;

import java.net.http.HttpRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postwithoughtAuthorization {

	
		

			@Test
			public void post() 
			{
				//Step1-Define the Base URL
				RestAssured.baseURI="http://reqres.in";
				
				//step2-Define HTTP Request
			
						
			RequestSpecification httpRequest=RestAssured.given();
			
			//Step3-create a json object for all feild -so add json simple dependencies inpom.xml
			org.json.simple.JSONObject requestJsone=new org.json.simple.JSONObject();
			requestJsone.put("name", "Rohit HOOda");
			requestJsone.put("name", "Gunnu HOOda");
			requestJsone.put("name", "Jobs HOOda");
			
			//Step 4:Add the header
			
			httpRequest.header("Content-Type","application/json;charset=utf-g");
			
			//step5- Add the json payload(Created in step 3) to the body of the request
			
			httpRequest.body(requestJsone.toJSONString());   //add payload and convert that into string
			
			//step6-post the request and get the response
			
				
			}
		
	

}
