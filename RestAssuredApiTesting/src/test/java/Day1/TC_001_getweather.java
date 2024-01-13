package Day1;

import java.net.UnknownHostException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_getweather {

	@Test
	void getweatherdetails()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
	
	//Requestobject
	
	RequestSpecification httpRequest=RestAssured.given();
	
	//ResponseObject
	Response response=httpRequest.request(Method.GET,"/Hydrabad");
	
	//print response in console window
	String responsebody=response.getBody().asString();
	System.out.println("Responsebody is"+responsebody);
		
		
	}
}
