package restAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class TC_01_ListUsers {

	Response resp;
	
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://reqres.in";
		resp = RestAssured.given().request(Method.GET, "/api/users?page=2");
	}
	@Test(priority=1)
	public void verifyListUsers() {
		
		System.out.println(resp.asString());
		System.out.println(resp.asPrettyString());
		
	}
	
	@Test(priority=2)
	public void verifyStatusCode() {
		
		int statusCode = resp.getStatusCode();
		System.out.println("Status Code is " + statusCode);
	}
	
	@Test(priority=3)
	public void verifyContentType() {
		String contentType= resp.getContentType();
		System.out.println("Content type is " +contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		Assert.assertTrue(contentType.contains("json"));
	}
	
	@Test(priority=4)
	public void verifyTransferEncoding(){
	String encoding = resp.getHeader("Transfer-Encoding");
	System.out.println("Transfer Encoding is " + encoding);
	Assert.assertEquals(encoding, "chunked");
}
}
