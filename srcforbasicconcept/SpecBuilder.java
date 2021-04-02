import static io.restassured.RestAssured.given;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {


	public static void main(String args[])
	{

	RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).build();
	
	//first way
	String response =given().spec(req).body(payload.addPlace()).when().post("/maps/api/place/add/json").then().spec(res).extract().response().asString();
	
	//second way
	RequestSpecification request=given().spec(req);
	String response2=request.body(payload.addPlace()).when().post("/maps/api/place/add/json").then().spec(res).extract().response().asString();
	System.out.println(response);
	System.out.println(response2);
	
	}
	
}
