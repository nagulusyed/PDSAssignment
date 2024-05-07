package APITests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import APIEndpoints.UserEndPointsPOJO;
import APIPayloads.UserPOJO;
import io.restassured.response.Response;

public class UserTestPOJO {
	
	UserPOJO UserPayload;
	UserPOJO UserPayload1;
	String CreatedUserId;
	
	@BeforeClass
	public void SetUp() {
	
		UserPayload=new UserPOJO();
		UserPayload1=new UserPOJO();
		
		//UserPayload.setId(599);
		UserPayload.setFirst_name("Nagulu");
		UserPayload.setLast_name("Syed");
		UserPayload.setEmail("Syed@gmail.com");
		UserPayload.setName("syed");
		UserPayload.setJob("engineer");
		
		
		UserPayload1.setFirst_name("Nagulu");
		UserPayload1.setLast_name("Syed");
		UserPayload1.setEmail("Syed@gmail.com");
		UserPayload1.setName("syednagulu");
		UserPayload1.setJob("engineer");
	}
	
	
	@Test(priority = 1)
	public void testCreateUser() {
		Response response = UserEndPointsPOJO.createUser(UserPayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
		CreatedUserId = response.then().extract().path("id");
		
		System.out.println(CreatedUserId);
	}

	
	@Test(priority = 2,dependsOnMethods = {"testCreateUser"})
	public void testGetUser() {
	    Response response = UserEndPointsPOJO.readUser(CreatedUserId);
	    System.out.println(CreatedUserId);
	    response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }
	
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		Response response=UserEndPointsPOJO.updateUser(CreatedUserId, UserPayload1);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4, dependsOnMethods = {"testUpdateUser"})
	public void testDeleteUser() {
		Response response=UserEndPointsPOJO.deleteUser(CreatedUserId);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	

	

}
