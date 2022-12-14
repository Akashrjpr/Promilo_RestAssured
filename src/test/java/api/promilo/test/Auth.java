package api.promilo.test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.promilo.generic.TestData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Auth {	
	
	@Test
	public void test59() throws IOException {
		String url = TestData.getTestData("url");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();
		String userName = TestData.getexceldata("sheet1", 60, 0);
		String source = TestData.getexceldata("sheet1", 60, 1);
		String password = TestData.getexceldata("sheet1", 60, 2);
		requestParam.put("userName",userName);
		requestParam.put("source",source);
		requestParam.put("password",password);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST, "/api/v1/usermgmt/login");
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
		String accessToken = response.jsonPath().get("access_token");
		Assert.assertNotNull(accessToken);
	}
	@Test(dataProvider = "login")
	public void test60_65(String userName, String source, String password) throws IOException {
		String url = TestData.getTestData("url");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();
		requestParam.put("userName",userName);
		requestParam.put("source",source);
		requestParam.put("password",password);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST, "/api/v1/usermgmt/login");
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 201);
		String accessToken = response.jsonPath().get("access_token");
		Assert.assertNotNull(accessToken);
	}
	
	@Test
	public void test80() throws IOException {
		String url = TestData.getTestData("URL");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/otpHistory");
		//compare status code.
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");
	}
	@Test
	public void test81() throws IOException {
		String url = TestData.getTestData("URL");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/loginHistory");
		//compare status code.
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");
	}
	

}
