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

public class TC_04_StaticImport_Ex1 {

	RequestSpecification httpRequest;
	
	@Test(dataProvider="testData")
	public void createUser(String name, String role ) {
		
		
		JSONObject requestBodyPut = new JSONObject();
		
		requestBodyPut.put("name",name);
		requestBodyPut.put("job", role);
		
		System.out.println(requestBodyPut.toJSONString());
		
		RestAssured.baseURI="https://reqres.in/";
		
		given().
		
		header("Content-Type", "application/json").
		
		body(requestBodyPut).
		
		when().
		
		post("/api/users").
		
		then().
		
		statusCode(201).
		
		body("name", equalTo(name)).

        body("job", equalTo(role)).

        log().all();
		
		
	}
	
	@DataProvider
	
	public Object[][] testData(){


        Object [] []  data = {{"Ananthu","leader"}, {"Hari","sr.leader"}, {"James","sr.leader"}, {"Vishal","leader"}};

        return data;
	}
}
