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
    public void checkTheAvailability() {
        request = RestAssured.given().
                header("User-Agent", "PostmanRuntime/7.28.4");
    }

    @When("I send a valid Get Request to Get Patterns API XML File")
    public void setGetRequest() {
        response = request.get();
    }

    @Then("response status code should be {int}")
    public void validateTheStatusCode(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    @And("I should see the Number of Views of Pattern {string} Greater Than {string}")
    public void validateTheNumViews(String patternNum, String threshold) {
        assertThat(response.then().extract().path("patterns.pattern[" + patternNum + "].numViews"),
                greaterThan(threshold));
    }
}
