package stepdefenition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ApiResources;
import utils.CommonUtils;
import payload.TestData;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class StepImplementation extends CommonUtils {

    RequestSpecification request;
    ResponseSpecification res;
    Response response;
    TestData td = new TestData();
    ApiResources resourceurl;
public    static String placeid;   //static we use here because the value of static variable not reset in single run till execution complete
    // here all above variable value will be reset for another scenario but static variable value will remain same till execution end.


    @Given("payload in Json format with {string} {string} {string}")
    public void addplacepayload_in_json_format_with(String name, String language, String address) throws IOException {

        request=given().spec(requestSpecification()).body(td.addPlacePayload(name,language,address));

    }
    @When("user calls {string} api with {string} http request")
    public void user_calls_api_with_http_request(String apiname, String methodname) {

        resourceurl=ApiResources.valueOf(apiname);
        System.out.println(resourceurl.getResource());

        if(methodname.equalsIgnoreCase("post"))
        response=request.when().post(resourceurl.getResource());
        else
        response=request.when().get(resourceurl.getResource());
    }
    @Then("i got response status code as {int}")
    public void i_got_response_status_code_as(Integer int1) {
      assertEquals(response.getStatusCode(),200);
    }

    @Then("{string} in response is {string}")
    public void in_response_is(String key, String value) {

        assertEquals(rawToJson(response,key),value);
    }
    @Then("verify {string} present in response of {string} based on placeid")
    public void verify_present_in_response_of_based_on_placeid(String expname, String apinameforresource) throws IOException {
        //fetching place id from response of add place api
         placeid=rawToJson(response,"place_id");
        //fetching resource url for get api
        resourceurl=ApiResources.valueOf(apinameforresource);
        //create request spec builder for get place api
        request=given().spec(requestSpecification()).queryParam("place_id",placeid);
     //   user_calls_api_with_http_request(apiname,"GET");
        //or
        response=request.get(resourceurl.getResource());
        String actualname=rawToJson(response,"name");
        assertEquals(expname,actualname);
    }

    @Given("delete place api payload")
    public void deletePlace() throws IOException {
        //Create request
        request=given().spec(requestSpecification()).body(td.deletePlacePayload(placeid));

    }




}
