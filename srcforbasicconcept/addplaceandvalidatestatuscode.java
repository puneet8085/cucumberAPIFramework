import io.restassured.RestAssured;
import io.restassured.assertion.BodyMatcher;

import static io.restassured.RestAssured.*;

import files.payload;

public class addplaceandvalidatestatuscode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//validate as Add place api is working as expected
		//RestAssured work on 2 keyword given  when and then
		// given - All input details
		//when - submit the api( give resource and http method type here)
		//then - validate the response
		//log().all(). method are used to show log in console
		
		RestAssured.baseURI="https://rahulshettyacademy.com";//base URL take server url i.e exclude resource part
		given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json")
		.body(payload.addPlace()).when().post("/maps/api/place/add/json").then().log().all()
		.assertThat().statusCode(200);
		
		
	}

}
