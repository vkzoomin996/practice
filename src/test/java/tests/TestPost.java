package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPost {
	@Test
	 public void Createusertest() {
		HashMap<String,String> obj = new HashMap<String , String>();
		obj.put("name", "veeresha");
		obj.put("job", "Automation Tester");
		baseURI = "https://reqres.in";
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/api/users")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201);
		}
}
