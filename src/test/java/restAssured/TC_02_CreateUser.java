package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_CreateUser {

	RequestSpecification httpRequest;
	
	@Test
	public void createUser() {
		
		
		JSONObject requestBody = new JSONObject();
		
		requestBody.put("name", "Sreeshna");
		requestBody.put("job", "leader");
		
		System.out.println(requestBody.toJSONString());
		
		RestAssured.baseURI="https://reqres.in/";
		
		httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestBody);
		
		Response resp = httpRequest.request(Method.POST,"/api/users");
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.getStatusCode());
		
		
	}
}
