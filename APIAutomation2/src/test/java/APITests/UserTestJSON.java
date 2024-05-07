package APITests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import APIEndpoints.UserEndPointsHASH;
import APIEndpoints.UserEndPointsJSON;
import io.restassured.response.Response;

public class UserTestJSON {
	
	public JSONObject data;
	public JSONObject data1;
	String CreatedUserId;
	
	@BeforeClass
	public void SetUp() throws FileNotFoundException {
		File file = new File(".\\data.json");
		FileReader fReader = new FileReader(file);
		JSONTokener jTokener = new JSONTokener(fReader);
		
		data = new JSONObject(jTokener); 
		
		File file1 = new File(".\\data1.json");
		FileReader fReader1 = new FileReader(file1);
		JSONTokener jTokener1 = new JSONTokener(fReader1);
		
		data1 = new JSONObject(jTokener1); 
	}
	
	@Test(priority = 1)
	public void testCreateUser() {

		Response response = UserEndPointsJSON.createUser(data);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
		CreatedUserId = response.then().extract().path("id");
		
		System.out.println(CreatedUserId);
	}
	
	@Test(priority = 2,dependsOnMethods = {"testCreateUser"})
	public void testGetUser() {
	    Response response = UserEndPointsJSON.readUser(CreatedUserId);
	    System.out.println(CreatedUserId);
	    response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }
	
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		Response response=UserEndPointsJSON.updateUser(CreatedUserId, data1);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4, dependsOnMethods = {"testUpdateUser"})
	public void testDeleteUser() {
		Response response=UserEndPointsJSON.deleteUser(CreatedUserId);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}

}
