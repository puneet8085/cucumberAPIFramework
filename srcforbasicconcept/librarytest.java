import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import files.reusablemethods;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class librarytest {
		
	//passing values for new book as a parameter value in body. so it will not fail if we change parameter again and again
	
	@Test(dataProvider  ="dynamic add book")
	public void addBookDynamically(String bname,String isb,int ais,String auth)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		String apiresponse=given().header("Content-Type","application/json").body(payload.addBookDynamic(bname,isb,ais,auth)).post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = reusablemethods.rawToJson(apiresponse);
		
	
			String bookid= js.getString("ID");
		
			//calling delete book api
			RestAssured.baseURI="http://216.10.245.166";
			given().header("Content-Type","application/json").body(payload.deleteBook(bookid)).post("/Library/DeleteBook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
			
	}
	
	@DataProvider(name= "dynamic add book")
	public Object[][] addMultipleBook()
	{
		Object [][]obj = new Object [4][4];
		
		obj[0][0]="book 011";
		obj[0][1]="isbn011";
		obj[0][2]= 001;
		obj[0][3]="author01";
		
		obj[1][0]="book 022";
		obj[1][1]="isbn022";
		obj[1][2]=002;
		obj[1][3]="author02";
		
		obj[2][0]="book 033";
		obj[2][1]="isbn033";
		obj[2][2]=003;
		obj[2][3]="author03";
		
		obj[3][0]="book 044";
		obj[3][1]="isbn044";
		obj[3][2]=004;
		obj[3][3]="author04";
		
		return obj;
		
	}
	
	
	
	
	
	
	//having hard coded value for adding new book . it will fail if we run second time bcz data will already present in server with these detials
	//@Test
	public void addBookStatic()
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		String apiresponse=given().header("Content-Type","application/json").body(payload.addBookStatic()).post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = reusablemethods.rawToJson(apiresponse);
		String bookid= js.getString("ID");
		System.out.println("ID of new book is : "+bookid);
		
	}
	
}
