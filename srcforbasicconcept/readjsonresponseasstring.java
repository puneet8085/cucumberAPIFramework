import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.payload;
import files.reusablemethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class readjsonresponseasstring {


	
	public static void main(String[] args) {
		
		//add place   ----> update address with new  ---- >Get place and validate new address present in JSOn response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";//base URL take server url i.e exclude resource part
		String postapiresponse=given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json")
		.body(payload.addPlace()).when().post("/maps/api/place/add/json").then().log().all()
		.assertThat().statusCode(200).body("status", equalTo("OK")).header("Server", "Apache/2.4.18 (Ubuntu)").extract()
		.response().asString();
		
		
		JsonPath js = reusablemethods.rawToJson(postapiresponse) ; //used to read/parse json and it take input in string format
	    String placeid=	js.get("place_id");//  getting value for place id key from JSON.
	    System.out.println(placeid);
	    
	    String address= "70 Summer NA USA";
	    
	    
	    //calling update Place aPi
	    given().log().all().queryParam("key","qaclick123" ).header("Content-Type","application/json")
	    .body(payload.updatePlace(placeid, address)).when().put("/maps/api/place/update/json").then().log().all()
		.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).header("Server", "Apache/2.4.18 (Ubuntu)");
	    
	    
	    //verify update address from the json response of get place API
	    
	   String getapiresponse= given().log().all().queryParam("key","qaclick123" ).queryParam("place_id",placeid)
	    .when().get("/maps/api/place/get/json")
	    .then().log().all().assertThat().statusCode(200).extract().response().asString();
	   
	   JsonPath js1=reusablemethods.rawToJson(getapiresponse);
	    	 //passing string to convert into string 
	    	 String newaddress = js1.get("address");
	    	 
	    Assert.assertEquals(newaddress,address);//  testng assert class used to validate values
	    
	   
	   System.out.println("----------------End of Execution--------------------------------");
	   
	   
	   //in json [] bracket represent array and inside it {} brakcet represent 1 vale of array.
	   
	   //we do api automation with moc/dummy as we have response format but api development is under progress.
	
	   
	   
	}
}
