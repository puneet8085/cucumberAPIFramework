import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.AddPlace;
import pojo.Location;

public class Serialization {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace ap=new AddPlace();
		ap.setAccuracy(100);
		ap.setAddress("Sector 18 Noida");
		ap.setLanguage("English");
		ap.setName("Test ADD place API");
		ap.setPhone_number(11111);
		ap.setWebsite("www.google.com");
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		ap.setLocation(loc);
		List<String> mylist = new ArrayList<String>();
		mylist.add("value 1");
		mylist.add("value 2");
		ap.setTypes(mylist);
				
	      String response =given().log().all().queryParam("key", "qaclick123")
	                       .body(ap).when().post("/maps/api/place/add/json").then().log().all()
			                .assertThat().statusCode(200).extract().response().asString();	
		
		
		
		
		
	}

}
