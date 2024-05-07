package APITests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import APIEndpoints.UserEndPointsPOJO;
import APIEndpoints.UserEndPointsHASH;
import APIPayloads.UserPOJO;
import io.restassured.response.Response;


public class UserTestHASH {
	
	String CreatedUserId;
	
	HashMap<String, String> data = new HashMap<String, String>();
	
	HashMap<String, String> data1 = new HashMap<String, String>();
	
	@BeforeClass
	public void SetUp() {
	
		data.put("email", "syed@gamil.com");
		data.put("first_name", "Nagulu");
		data.put("last_name", "Syed");
		data.put("name", "syednagulu");
		data.put("job", "engineer");
		
		
		data1.put("email", "syed@gamil.com");
		data1.put("first_name", "Nagulu");
		data1.put("last_name", "Syed");
		data1.put("name", "nagulusyed");
		data1.put("job", "engineer");
	
	}
	
	@Test(priority = 1)
	public void testCreateUser() {

		Response response = UserEndPointsHASH.createUser(data);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
		CreatedUserId = response.then().extract().path("id");
		
		System.out.println(CreatedUserId);
	}
	
	
	@Test(priority = 2,dependsOnMethods = {"testCreateUser"})
	public void testGetUser() {
	    Response response = UserEndPointsHASH.readUser(CreatedUserId);
	    System.out.println(CreatedUserId);
	    response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }
	
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		Response response=UserEndPointsHASH.updateUser(CreatedUserId, data1);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4, dependsOnMethods = {"testUpdateUser"})
	public void testDeleteUser() {
		Response response=UserEndPointsHASH.deleteUser(CreatedUserId);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}

}
