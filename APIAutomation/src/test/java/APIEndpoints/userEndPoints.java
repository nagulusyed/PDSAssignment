package APIEndpoints;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	@Test
	public void getBookDetails() {
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void postBookDetails() {
		String BookTitle = "HarryPorter";
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(BookTitle)
		.when()
			.post(Routes.post_url)
		.then()
			.statusCode(400)
			.extract().response();
		int statusCode = response.getStatusCode();
	    System.out.println("Create Book Status Code: " + statusCode);
	}
	 
	
	@Test
	public void getNewBookDetails() {
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.get(Routes.get_url)
		.then()
			.statusCode(200)
			.body("BookTitle", equalTo("HarryPorter"))
			.log().all();
	}
	

	

}
