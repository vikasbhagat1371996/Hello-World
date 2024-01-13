package Day1;

import org.testng.annotations.Test;

//By Manuaaly add following three packges  and static keyword add by manually because it is static packages

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
given()
     content type,set cookies,add auth,,add param,set headers info etc

when()
    get, post,put,delete

then()
    validate status code,extract response,extract headers cookies and response bodies....

*/

public class HTTPPRequests {
	
	int id;
	
	@Test(priority=1)
	void getUsers()
	{
//		given()              //out of following three method in that first method donot require dot.
		                      //you directly start dot . by second method  
		when()
		  .get("https://reqres.in/api/users?page=2")
		   
		.then()
		  .statusCode(200)
		  .body("page",equalTo(2))
		  .log().all();
	}
	@Test(priority=2)
	void createuser()
	{
		
		HashMap data=new HashMap();
		data.put("name","pavan");
		data.put("job","trainer");
		
	id=	given()
		.contentType("application/json")
		.body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");  //getInt becaues it is id is number and if name is present then put getString
		
		//.then()
		//  .statusCode(201)
		//  .log().all();
	}
	@Test(priority=3,dependsOnMethods= {"createuser"})
	void updateUsers()
	{
		HashMap data=new HashMap();
		data.put("name","johan");
		data.put("job","teacher");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		  .put("https://reqres.in/api/users/"+id)//concatanation with id
		   //getInt becaues it is id is number and if name is present then put getString
		
		  
		  .then()
		    .statusCode(200)
		    .log().all();
	}
	@Test(priority=4)
	void deleteusers() {
		
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/usersid")
		
		.then()
		.statusCode(204)
		.log().all();
	}

}
