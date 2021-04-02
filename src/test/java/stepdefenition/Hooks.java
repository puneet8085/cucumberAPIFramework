package stepdefenition;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeDeletePlace() throws IOException {
        StepImplementation stepImplementation=new StepImplementation();
        if(StepImplementation.placeid==null) {
            // writing this tagged hook if i want to execute delete place api scenario only by giving its tag inside runner class
            stepImplementation.addplacepayload_in_json_format_with("puneet", "punjabi", "Amritsar");
            stepImplementation.user_calls_api_with_http_request("addPlaceApi", "post");
            stepImplementation.verify_present_in_response_of_based_on_placeid("puneet", "getPlaceApi");
        }

    }

}
