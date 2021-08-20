package StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinitions extends Utilities {

	RequestSpecification req1;
	RequestSpecification req;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;

	@Given("Add the place payload {string} {string}")
	public void add_the_place_payload(String name, String language) throws IOException {
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();
		req1 = given().spec(requestSpecs()).body(data.addPlacePayLoad(name, language));

	}

	@When("user calls the {string}  payload with {string} http request")
	public void user_calls_the_addplaceapi_payload_with_post_http_request(String resource, String method) {

		APIResources resourceapi = APIResources.valueOf(resource);
		System.out.println(resourceapi.getResource());
		// response =
		// req1.when().post(resourceapi.getResource()).then().assertThat().body("scope",
		// equalTo("APP"))
		// .extract().response();

		if (method.equalsIgnoreCase("Post")) {
			response = req1.when().post(resourceapi.getResource());
			System.out.println(response.asString());

		} else if (method.equalsIgnoreCase("Get")) {
			response = req1.when().get(resourceapi.getResource());

		}
	}

	@Then("the API got Success with Status code {int}")
	public void the_api_got_success_with_status_code(Integer int1) {

		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void status_in_response_body_is_ok(String key, String value) {
		String responseString = response.asString();
		JsonPath jsonString = new JsonPath(responseString);
		place_id = jsonString.get("place_id");
		System.out.println(place_id);
		assertEquals(jsonString.get(key).toString(), "OK");

	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws IOException {

		String place_id = getJsonpath(response, "place_id");
		req1 = given().spec(requestSpecs()).queryParam("place_id", place_id);
		user_calls_the_addplaceapi_payload_with_post_http_request(resource, "Get");
		String actualName = getJsonpath(response, "name");
		assertEquals(actualName, Expectedname);

	}
	
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws IOException {
		
		req1 = given().spec(requestSpecs()).body(data.deletePlacePayLoad(place_id));
	
	    
	}



}
