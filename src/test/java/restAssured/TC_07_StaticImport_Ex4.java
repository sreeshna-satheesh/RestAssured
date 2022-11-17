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

public class TC_07_StaticImport_Ex4 {

	RequestSpecification httpRequest;
	
	String name = "Asha";

	String role = "leader";
	
	@Test()
	public void createUser( ) {
		
		
		JSONObject requestBodyPut = new JSONObject();
		
		
		
		System.out.println(requestBodyPut.toJSONString());
		
		RestAssured.baseURI="https://api.github.com/";
		
		given().
		
		header("Content-Type", "application/json").
		
		auth().oauth2("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").
		
		when().
		
		get("/user/repos").
		
		then().
		
		statusCode(200).
		
        log().all();
		
		
	}
	

}
