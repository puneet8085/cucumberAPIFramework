import static io.restassured.RestAssured.given;
import static org.hamcrest.Matcher.*;
import org.testng.annotations.Test;

import files.payload;
import files.reusablemethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class jiracookiesapi {
	
	@Test
	public void jiraCookiesAPI()
	{
		
		RestAssured.baseURI="https://puneet8085.atlassian.net";
		String apiresponse=given().relaxedHTTPSValidation().header("Content-Type","application/json").body(payload.jiraCookiesPayload()).post("/rest/auth/1/session")
		.then().log().all().extract().response().asString();
		
		JsonPath js = reusablemethods.rawToJson(apiresponse);
		
     	System.out.println(apiresponse);
		
	}

}
