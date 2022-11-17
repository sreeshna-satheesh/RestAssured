package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_06_StaticImport_Ex3 {

	RequestSpecification httpRequest;
	
	String name = "Asha";

	String role = "leader";
	
	@Test()
	public void createUser( ) {
		
		
		JSONObject requestBodyPut = new JSONObject();
		
		requestBodyPut.put("name",name);
		requestBodyPut.put("job", role);
		
		System.out.println(requestBodyPut.toJSONString());
		
		RestAssured.baseURI="https://reqres.in/";
		
		given().
		
		header("Content-Type", "application/json").
		
		body(requestBodyPut).
		
		when().
		
		delete("/api/users/{id}", 2).
		
		then().
		
		statusCode(204).
		
        log().all();
		
		
	}
	

}
