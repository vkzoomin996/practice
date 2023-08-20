package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestExamples2 {
	@Test
	public void test_2() {
		baseURI ="https://reqres.in/api";
		 
				Response res =when()
				.get("/users?page=2");
				res.then()
				.assertThat().statusCode(200).log().all();
				int actvalue=res.jsonPath().get("data[1].id");
				Assert.assertEquals(actvalue,8);
	}

} 