package APIEndpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import APIPayloads.UserPOJO;
public class UserEndPoints {
	
	public static Response createUser(UserPOJO userPayload)
	{
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(userPayload)
				.when()
					.post(Routes.post_url);
		return response;
	}
	
	public static Response readUser(String createdUserId)
	{
		
		Response response = 
				given()
					.pathParam("createdUserId", createdUserId)
				.when()
					.get(Routes.get_url);
		return response;
	}
	public static Response updateUser(String createdUserId, UserPOJO payload)
	{
		Response response = 
				given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("createdUserId", createdUserId)
					.body(payload)
				.when()
					.put(Routes.update_url);
		return response;
	}
	
	public static Response deleteUser(String createdUserId)
	{
		Response response = 
				given()
					.pathParam("createdUserId", createdUserId)
				.when()
					.delete(Routes.delete_url);
		return response;
	}

}
