import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;

public class passbodyfromjsonformatfile {

	
	@Test
	public void readBodyFromJsonFileFormat() throws IOException
	{
		
		//write body like "new String (Files.readAllBytes(Paths.get("./jsonfile/addplace.json")))" to read data from json file
		RestAssured.baseURI="https://rahulshettyacademy.com";//base URL take server url i.e exclude resource part
		given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Paths.get("./jsonfile/addplace.json")))).when().post("/maps/api/place/add/json").then().log().all()
		.assertThat().statusCode(200);
	}
}
