package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03_UpdateUser {

	RequestSpecification httpRequest;
	
	@Test
	public void createUser() {
		
		
		JSONObject requestBodyPut = new JSONObject();
		
		requestBodyPut.put("name", "Sreeshna");
		requestBodyPut.put("job", "leader");
		
		System.out.println(requestBodyPut.toJSONString());
		
		RestAssured.baseURI="https://reqres.in/";
		
		httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestBodyPut);
		
		Response resp = httpRequest.request(Method.PUT,"/api/users/2");
		
		System.out.println(resp.asPrettyString());
		
		System.out.println(resp.getStatusCode());
		
		System.out.println(resp.getTime());
		
		
	}
}
