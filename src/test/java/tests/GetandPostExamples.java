package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;


public class GetandPostExamples {

	@Test
	public void testGet() {
		baseURI ="https://reqres.in/api";
		 
		Response res =when()
		.get("/users?page=2");
		res.then()
		.assertThat().statusCode(200).log().all();
		String actvalue=res.jsonPath().get("data[3].first_name");
		Assert.assertEquals(actvalue,"Byron");
  }
	@Test
	public void testPost()
	{
		HashMap<String,String> obj = new HashMap<String , String>();
		obj.put("name", "veeresha");
		obj.put("job", "Automation Tester");
		baseURI ="https://reqres.in";
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
	