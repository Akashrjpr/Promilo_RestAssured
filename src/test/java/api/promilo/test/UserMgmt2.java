package api.promilo.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.promilo.generic.DataProvider;
import com.promilo.generic.TestData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserMgmt2 {
	
	@Test(dataProvider = "otpLogin", dataProviderClass = DataProvider.class)
	public void test31_38(String id, String userName, String source, String otpPassword) throws IOException {
		
			
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		requestParam.put("userName", userName);
		requestParam.put("source", source);
		requestParam.put("otpPassword", otpPassword);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/loginWithOtp");
		int statusCode = response.statusCode();
		System.out.println(response.body().asString());
		if(id.equals("1")) {		
		Assert.assertEquals(statusCode,200, "Status code not matching");
		}
		else {
			Assert.assertEquals(statusCode,400, "Status code not matching");
		}
		
	}
	@Test
	public void test39() throws IOException {		
		String auth = TestData.getTestData("auth");
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2(auth);;
		String id = TestData.getexceldata("Sheet1", 39, 0);		
		httpRequest.header("Content-Type","application/json");
		Response response = httpRequest.request(Method.PUT,"/api/v1/usermgmt/inActiveStatus/");
		int statusCode = response.statusCode();			
		Assert.assertEquals(statusCode,200, "Status code not matching");		
	}
	@Test
	public void test40() throws IOException {		
		
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		String id = TestData.getexceldata("Sheet1", 40, 0);		
		httpRequest.header("Content-Type","application/json");
		Response response = httpRequest.request(Method.PUT,"/api/v1/usermgmt/inActiveStatus/");
		int statusCode = response.statusCode();			
		Assert.assertEquals(statusCode,400, "Status code not matching");		
	}
	
	@Test(dataProvider = "activeStatus", dataProviderClass = DataProvider.class)
	public void test41_45(String id, String userName, String source, String otpPassword) throws IOException {
		
			
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		requestParam.put("userName", userName);
		requestParam.put("source", source);
		requestParam.put("otpPassword", otpPassword);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/loginWithOtp");
		int statusCode = response.statusCode();
		System.out.println(response.body().asString());
		if(id.equals("1")) {		
		Assert.assertEquals(statusCode,200, "Status code not matching");
		}
		else {
			Assert.assertEquals(statusCode,400, "Status code not matching");
		}
		
	}
	@Test
	public void test46() throws IOException {		
		
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		String refcode = TestData.getexceldata("Sheet1", 48, 0);		
		httpRequest.header("Content-Type","application/json");
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/referral/"+refcode);
		int statusCode = response.statusCode();			
		Assert.assertEquals(statusCode,200, "Status code not matching");		
	}
	@Test
	public void test47() throws IOException {		
		
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		String refcode = TestData.getexceldata("Sheet1", 49, 0);		
		httpRequest.header("Content-Type","application/json");
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/referrals/"+refcode);
		int statusCode = response.statusCode();			
		Assert.assertEquals(statusCode,400, "Status code not matching");		
	}
	@Test
	public void test4850(String email) throws IOException {
		String url = TestData.getTestData("URL");
		String auth = TestData.getTestData("auth");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2(auth);
		JSONObject requestParam = new JSONObject();		
		requestParam.put("email", email);		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/inviteUser");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");	
	}
	@Test
	public void test4951(String email) throws IOException {
		String url = TestData.getTestData("URL");
		String auth = TestData.getTestData("auth");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();		
		requestParam.put("email", email);		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/verificationOTP");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,401, "Status code not matching");	
	}
	
	@Test(dataProvider = "verifyOTP")
	public void test55_57(String userName, String source, String otp) throws IOException {
		String url = TestData.getTestData("URL");
		String auth = TestData.getTestData("auth");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();		
		requestParam.put("userName", userName);	
		requestParam.put("source", source);	
		requestParam.put("otp", otp);	
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/verificationOTP");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");	
	}
	@Test
	public void test54() throws IOException {
		String url = TestData.getTestData("URL");
		String auth = TestData.getTestData("auth");
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParam = new JSONObject();		
		String userName = TestData.getexceldata("sheet1",55, 0);
		String source = TestData.getexceldata("sheet1",55, 1);
		String otp = TestData.getexceldata("sheet1",55, 2);
		requestParam.put("userName", userName);	
		requestParam.put("source", source);	
		requestParam.put("otp", otp);	
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/inviteUser");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");	
	}	
}
