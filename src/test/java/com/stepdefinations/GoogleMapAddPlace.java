package com.stepdefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;

import com.resources.GoogleMapAddNewPlaceTestData;
import com.resources.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GoogleMapAddPlace extends Utils{

	RequestSpecification request;
	ResponseSpecification resp;
	Response response;
	GoogleMapAddNewPlaceTestData addMapTestData = new GoogleMapAddNewPlaceTestData();
	
	@Given("User having request payload with {string} {string} {string}")
	public void user_having_request_payload_with(String placeName, String placeLanguage, String placeAddress) throws IOException {
		request=given().spec(requestSpecification())
				.body(addMapTestData.addNewPlaceRequestPayload(placeName, placeLanguage, placeAddress));
	}
	
	@When("User requests {string} API with {string} Http request")
	public void user_requests_api_with_http_request(String apiNAme, String httpMethod) {
		resp=new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		
		response=request.when().post("/maps/api/place/add/json")
    			.then().spec(resp).extract().response();
	}
	
	@Then("Validate status code is {string}")
	public void validate_status_code_is(String statusCode) {
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@And("Validate response having jsonPath key {string} with value as {string}")
	public void validate_response_having_json_path_with_value_as(String jsonPath, String value) {
		String responseString=response.asString();
        JsonPath jsPath=new JsonPath(responseString);
        Assert.assertEquals(value, jsPath.get(jsonPath));
	}
}
