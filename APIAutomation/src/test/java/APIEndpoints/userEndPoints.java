package APIEndpoints;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.http.ContentType;

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
		String title = "HarryPorter";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(title)
		.when()
			.post(Routes.post_url)
		.then()
			.statusCode(400)
			.log().all();
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
			.body("title", equalTo("HarryPorter"))
			.log().all();
	}
	

	

}
