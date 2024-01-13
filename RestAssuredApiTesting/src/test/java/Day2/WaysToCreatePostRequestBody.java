package Day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/*
 How many ways we create request body
------------
1)HashMap
2)using org.json
3)By using POJO(Plain old java object)
4)using external json file 
 */

public class WaysToCreatePostRequestBody {
	
	//1)post request body using HashMap
	
//	@Test(priority=1)
	void testpostusingHashMap()
	{
		HashMap data =new HashMap();
		
		data.put("name", "Scott");
		data.put("Location","France");
		data.put("phone","123456");
		
		String courseArr[]= {"c","c++"};
		data.put("courses",courseArr);
		
		given()
		  .contentType("application/json")
		  .body(data)		
		
		.when()
		  .post("https://reqres.in/api/users")
		
		
	.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("phone", equalTo("123456"))
/*		.body("location", equalTo("France"))
		.body("location", equalTo("France"))
		.body("courses[0]", equalTo("c++"))
		.body("courses[1]", equalTo("c"))
		.header("Content-Type","application/json;charset=utf-8")            */
		.log().all();
		
	}
	//usingorgjsonlibrary
	//@Test(priority=1)
	void testpostusingorgjsonlibrary()
	{
	JSONObject data =new JSONObject ();
		
		data.put("name", "Scott");
		data.put("Location","France");
		data.put("phone","123456");
		
		String courseArr[]= {"c","c++"};
		data.put("courses",courseArr);
		
		given()
		  .contentType("application/json")
		  .body(data.toString())	//in org.json topass the data by using .tostring method must and 	
		
		.when()
		  .post("https://reqres.in/api/users")
		
		
	.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("phone", equalTo("123456"))
/*		.body("location", equalTo("France"))
		.body("location", equalTo("France"))
		.body("courses[0]", equalTo("c++"))
		.body("courses[1]", equalTo("c"))
		.header("Content-Type","application/json;charset=utf-8")            */
		.log().all();
		
	}
	
	//usingPOJO class
	//@Test(priority=1)
		void testpostusingPOJO()
		{
		pojo_postRequest data =new pojo_postRequest();
			
			data.setName("Scott");
			data.setLocation("France");
			data.setPhone("123456");
			
			String courseArr[]= {"c","c++"};
			data.setCourses(courseArr);
			
			given()
			  .contentType("application/json")
			  .body(data.toString())	//in org.json topass the data by using .tostring method must and 	
			
			.when()
			  .post("https://reqres.in/api/users")
			
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("phone", equalTo("123456"))
	/*		.body("location", equalTo("France"))
			.body("location", equalTo("France"))
			.body("courses[0]", equalTo("c++"))
			.body("courses[1]", equalTo("c"))
			.header("Content-Type","application/json;charset=utf-8")            */
			.log().all();
			
		}
		//usingExternalJsonfile
		@Test(priority=1)
		void testpostusingExternalJsonfile() throws FileNotFoundException
		{
		pojo_postRequest data =new pojo_postRequest();
			
			File f=new File(".\\BODY.json");
			FileReader fr=new FileReader(f);
			JSONTokener jt=new JSONTokener(fr);
			JSONObject  data1 =new JSONObject ( jt);
			
			given()
			  .contentType("application/json")
			  .body(data1.toString())	//in org.json topass the data by using .tostring method must and 	
			
			.when()
			  .post("https://reqres.in/api/users")
			
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("phone", equalTo("123456"))
	/*		.body("location", equalTo("France"))
			.body("location", equalTo("France"))
			.body("courses[0]", equalTo("c++"))
			.body("courses[1]", equalTo("c"))
			.header("Content-Type","application/json;charset=utf-8")            */
			.log().all();
			
		}
	//Delation Student record
	
	@ Test(priority=2)
	void testdelete()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users")
		
		.then()
		.statusCode(200);
	}

}
