package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class GetRequestSteps {
    RequestSpecification request;
    Response response;

    @Before
    public void setTheBaseURL() {
        RestAssured.baseURI = "http://www.colourlovers.com/api/patterns";
    }

    @Given("Color Lover Patterns API endpoint exists")
    public void Color_Lover_Patterns_API_endpoint_exists() {
        request = RestAssured.given().
                header("User-Agent", "PostmanRuntime/7.28.4");
    }

    @When("I send a valid Get Request to Get Patterns API XML File")
    public void I_send_a_valid_Get_Request_to_Get_Patterns_API_XML_File() {
        response = request.get();
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    @And("I should see the Number of Views of Pattern {string} Greater Than {string}")
    public void I_should_see_the_Number_of_Views_of_Patter(String patternNum, String threshold) {
        assertThat(response.then().extract().path("patterns.pattern[" + patternNum + "].numViews"),
                greaterThan(threshold));
        System.out.println(response.then().extract().path("patterns.pattern[" + patternNum + "].numViews").toString());
    }
}
