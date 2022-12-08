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

public class UserMgmt{
	
	@Test
	public void test7() throws IOException {
		String url = TestData.getTestData("URL");
		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/user");
		//compare status code.
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");
	}
	@Test(priority = 1)
	public void test1() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 2, 1);
		String password = TestData.getexceldata("Sheet1", 2, 2);
		String source = TestData.getexceldata("Sheet1", 2, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 2, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		
		System.out.println("test1"+response.jsonPath().get("message"));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");
		String userName = response.jsonPath().get("data.userName");
		int roleID = response.jsonPath().get("data.roleId");
		String aEmail = response.jsonPath().get("data.email");
		String createdAt = response.jsonPath().get("data.createdAt");
		String updatedAt = response.jsonPath().get("data.updatedAt");
		String mobile = response.jsonPath().get("data.mobile");
		int id = response.jsonPath().get("data.id");
		
		Assert.assertEquals(userName, email, "username not matching");
		Assert.assertEquals(roleID, 1, "Role id not matching");
		Assert.assertEquals(aEmail, email, "email not matching");
		Assert.assertEquals(createdAt, updatedAt,"created and updated not matching");
		Assert.assertEquals(mobile, null, "mobile is not present");
		Assert.assertNotNull(id,"id is null");	
	}

	@Test(priority = 1)
	public void test5() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 6, 1);
		String password = TestData.getexceldata("Sheet1", 6, 2);
		String source = TestData.getexceldata("Sheet1", 6, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 6, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		
		System.out.println("test5"+response.jsonPath().get("message"));
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");
		String userName = response.jsonPath().get("data.userName");
		int roleID = response.jsonPath().get("data.roleId");
		String aMobile = response.jsonPath().get("data.mobile");
		String createdAt = response.jsonPath().get("data.createdAt");
		String updatedAt = response.jsonPath().get("data.updatedAt");
		String aEmail = response.jsonPath().get("data.email");
		int id = response.jsonPath().get("data.id");
		
		Assert.assertEquals(userName, email, "username not matching");
		Assert.assertEquals(roleID, 1, "Role id not matching");
		Assert.assertEquals(aMobile, email, "email not matching");
		Assert.assertEquals(createdAt, updatedAt,"created and updated not matching");
		Assert.assertEquals(aEmail, null, "email is not present");
		Assert.assertNotNull(id,"id is null");	
		
	}

	@Test
	public void test2() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 3, 1);
		String password = TestData.getexceldata("Sheet1", 3, 2);
		String source = TestData.getexceldata("Sheet1", 3, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 3, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		System.out.println("test2"+response.jsonPath().get("message"));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
	}

	@Test
	public void test3() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 4, 1);
		String password = TestData.getexceldata("Sheet1", 4, 2);
		String source = TestData.getexceldata("Sheet1", 4, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 4, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		System.out.println("test3"+response.jsonPath().get("message"));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
	}

	@Test
	public void test4() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 5, 1);
		String password = TestData.getexceldata("Sheet1", 5, 2);
		String source = TestData.getexceldata("Sheet1", 5, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 5, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		System.out.println("test4"+response.jsonPath().get("message"));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
	}

	@Test
	public void test6() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 7, 1);
		String password = TestData.getexceldata("Sheet1", 7, 2);
		String source = TestData.getexceldata("Sheet1", 7, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 7, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		System.out.println("test6"+response.jsonPath().get("message"));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
	}
	
	@Test(priority = 1)
	public void test6a() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 8, 1);
		String password = TestData.getexceldata("Sheet1", 8, 2);
		String source = TestData.getexceldata("Sheet1", 8, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 8, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		
		System.out.println("test6a"+response.jsonPath().get("message"));
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");
		String userName = response.jsonPath().get("data.userName");
		int roleID = response.jsonPath().get("data.roleId");
		String aEmail = response.jsonPath().get("data.email");
		String createdAt = response.jsonPath().get("data.createdAt");
		String updatedAt = response.jsonPath().get("data.updatedAt");
		String mobile = response.jsonPath().get("data.mobile");
		int id = response.jsonPath().get("data.id");
		
		Assert.assertEquals(userName, email, "username not matching");
		Assert.assertEquals(roleID, 2, "Role id not matching");
		Assert.assertEquals(aEmail, email, "email not matching");
		Assert.assertEquals(createdAt, updatedAt,"created and updated not matching");
		Assert.assertEquals(mobile, null, "mobile is not present");
		Assert.assertNotNull(id,"id is null");	
	}

	@Test(priority = 1)
	public void test6b() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String email = TestData.getexceldata("Sheet1", 9, 1);
		String password = TestData.getexceldata("Sheet1", 9, 2);
		String source = TestData.getexceldata("Sheet1", 9, 3);
		String userRefCode = TestData.getexceldata("Sheet1", 9, 4);
		
		requestParam.put("userName", email);
		requestParam.put("password", password);
		requestParam.put("source",source );
		requestParam.put("userReferralCode", userRefCode);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/user");
		
		System.out.println("test5"+response.jsonPath().get("message"));
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");
		String userName = response.jsonPath().get("data.userName");
		int roleID = response.jsonPath().get("data.roleId");
		String aMobile = response.jsonPath().get("data.mobile");
		String createdAt = response.jsonPath().get("data.createdAt");
		String updatedAt = response.jsonPath().get("data.updatedAt");
		String aEmail = response.jsonPath().get("data.email");
		int id = response.jsonPath().get("data.id");
		
		Assert.assertEquals(userName, email, "username not matching");
		Assert.assertEquals(roleID, 2, "Role id not matching");
		Assert.assertEquals(aMobile, email, "email not matching");
		Assert.assertEquals(createdAt, updatedAt,"created and updated not matching");
		Assert.assertEquals(aEmail, null, "email is not present");
		Assert.assertNotNull(id,"id is null");	
		
	}

	@Test
	public void test8() throws IOException {
		String url = TestData.getTestData("URL");		
		String eid = TestData.getTestData("id");
		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/user/"+eid);
		//compare status code.
		String aid = ""+response.jsonPath().get("id");
		int statusCode = response.statusCode();
		Assert.assertEquals(eid, aid, "ID not matching");
		Assert.assertEquals(statusCode,200, "Status code not matching");
	}

	@Test
	public void test9() throws IOException {
		String url = TestData.getTestData("URL");
		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.GET,"/api/v1/usermgmt/user/200");
		//compare status code.
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
		System.out.println(response.jsonPath().get("message"));
	}
	
	@Test
	public void test10() throws IOException {
		String url = TestData.getTestData("URL");
		String eid = TestData.getTestData("id");
		System.out.println(eid);
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.DELETE,"/api/v1/usermgmt/deleteUsers/"+eid);
		//compare status code.
		int statusCode = response.statusCode();
		String aid = ""+response.jsonPath().get("data.id");
		Assert.assertEquals(eid, aid, "ID not matching");
		Assert.assertEquals(statusCode,200, "Status code not matching");
		System.out.println(response.jsonPath().get("message"));
	}
	
	@Test
	public void test11() throws IOException {
		String url = TestData.getTestData("URL");
		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		// sending request and receiving response.
		Response response = httpRequest.request(Method.DELETE,"/api/v1/usermgmt/deleteUsers/200");
		//compare status code.
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
		System.out.println(response.jsonPath().get("message"));
	}
	
	@Test
	public void test12() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjgsInNpZ251cFR5cGUiOiJub3JtYWwiLCJyb2xlSWQiOjEsImV4cGlyZXNJbiI6IjMwZCIsImlhdCI6MTY3MDQxNjk5N30.PeJ5CCov_nQxQKnjYn5pWmk-ovPKVVt1sNMV1T1rlds");

		JSONObject requestParam = new JSONObject();
		String id = TestData.getexceldata("Sheet1", 12, 1);
		String oldPass = TestData.getexceldata("Sheet1", 12, 2);
		String newPass = TestData.getexceldata("Sheet1", 12, 3);
		
		requestParam.put("userAccountId", id);
		requestParam.put("oldPassword", oldPass);
		requestParam.put("newPassword",newPass );
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/resetPassword");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");
		String message = response.jsonPath().get("data.message");
		System.out.println(message);
	}

	@Test
	public void test13() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjgsInNpZ251cFR5cGUiOiJub3JtYWwiLCJyb2xlSWQiOjEsImV4cGlyZXNJbiI6IjMwZCIsImlhdCI6MTY3MDQxNjk5N30.PeJ5CCov_nQxQKnjYn5pWmk-ovPKVVt1sNMV1T1rlds");

		JSONObject requestParam = new JSONObject();
		String id = TestData.getexceldata("Sheet1", 13, 1);
		String oldPass = TestData.getexceldata("Sheet1", 13, 2);
		String newPass = TestData.getexceldata("Sheet1", 13, 3);
		
		requestParam.put("userAccountId", id);
		requestParam.put("oldPassword", oldPass);
		requestParam.put("newPassword",newPass );
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/resetPassword");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
		String message = response.jsonPath().get("data.message");
		System.out.println(message);
	}
	@Test
	public void test14() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjgsInNpZ251cFR5cGUiOiJub3JtYWwiLCJyb2xlSWQiOjEsImV4cGlyZXNJbiI6IjMwZCIsImlhdCI6MTY3MDQxNjk5N30.PeJ5CCov_nQxQKnjYn5pWmk-ovPKVVt1sNMV1T1rlds");

		JSONObject requestParam = new JSONObject();
		String id = TestData.getexceldata("Sheet1", 14, 1);
		String oldPass = TestData.getexceldata("Sheet1", 14, 2);
		String newPass = TestData.getexceldata("Sheet1", 14, 3);
		
		requestParam.put("userAccountId", id);
		requestParam.put("oldPassword", oldPass);
		requestParam.put("newPassword",newPass );
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/resetPassword");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
		String message = response.jsonPath().get("data.message");
		System.out.println(message);
	}
	@Test
	public void test15() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjgsInNpZ251cFR5cGUiOiJub3JtYWwiLCJyb2xlSWQiOjEsImV4cGlyZXNJbiI6IjMwZCIsImlhdCI6MTY3MDQxNjk5N30.PeJ5CCov_nQxQKnjYn5pWmk-ovPKVVt1sNMV1T1rlds");

		JSONObject requestParam = new JSONObject();
		String id = TestData.getexceldata("Sheet1", 15, 1);
		String oldPass = TestData.getexceldata("Sheet1", 15, 2);
		String newPass = TestData.getexceldata("Sheet1", 15, 3);
		
		requestParam.put("userAccountId", id);
		requestParam.put("oldPassword", oldPass);
		requestParam.put("newPassword",newPass );
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/resetPassword");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,400, "Status code not matching");
		String message = response.jsonPath().get("data.message");
		System.out.println(message);
	}
	@Test
	public void test16() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjgsInNpZ251cFR5cGUiOiJub3JtYWwiLCJyb2xlSWQiOjEsImV4cGlyZXNJbiI6IjMwZCIsImlhdCI6MTY3MDQxNjk5N30.PeJ5CCov_nQxQKnjYn5pWmk-ovPKVVt1sNMV1T1rlds");

		JSONObject requestParam = new JSONObject();
		String id = TestData.getexceldata("Sheet1", 16, 1);
		String oldPass = TestData.getexceldata("Sheet1", 16, 2);
		String newPass = TestData.getexceldata("Sheet1", 16, 3);
		
		requestParam.put("userAccountId", id);
		requestParam.put("oldPassword", oldPass);
		requestParam.put("newPassword",newPass );
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/resetPassword");
		System.out.println(response.body().asString());
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,201, "Status code not matching");
	}
	@Test
	public void test17() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String id = TestData.getexceldata("Sheet1", 17, 1);
		String oldPass = TestData.getexceldata("Sheet1", 17, 2);
		String newPass = TestData.getexceldata("Sheet1", 17, 3);
		
		requestParam.put("userAccountId", id);
		requestParam.put("oldPassword", oldPass);
		requestParam.put("newPassword",newPass );
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/resetPassword");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,401, "Status code not matching");
		String message = response.jsonPath().get("data.message");
		System.out.println(message);		
	}
	
	@Test
	public void test18() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String emailPh = TestData.getexceldata("Sheet1", 19, 1);
		
		requestParam.put("emailOrMobile", emailPh);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/sendForgotPasswordEmail");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");		
	}
	@Test
	public void test19() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String emailPh = TestData.getexceldata("Sheet1", 20, 1);
		
		requestParam.put("emailOrMobile", emailPh);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/sendForgotPasswordEmail");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");		
	}
	@Test
	public void test20() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String emailPh = TestData.getexceldata("Sheet1", 21, 1);
		
		requestParam.put("emailOrMobile", emailPh);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/sendForgotPasswordEmail");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");		
	}
	@Test
	public void test21() throws IOException {
		String url = TestData.getTestData("URL");		
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		String emailPh = TestData.getexceldata("Sheet1", 22, 1);
		
		requestParam.put("emailOrMobile", emailPh);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response = httpRequest.request(Method.POST,"/api/v1/usermgmt/sendForgotPasswordEmail");
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode,200, "Status code not matching");		
	}
}
