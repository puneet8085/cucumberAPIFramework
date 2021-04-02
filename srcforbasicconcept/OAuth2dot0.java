
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.Api;
import pojo.GetCourse;


public class OAuth2dot0 {

	public static void main(String[] args) throws InterruptedException {
		
		// hit below URL in browser and enter username /password. then copy new URL from browser and put as a value for URL variable in below code.
//		https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifyfjdss");
		
		String url ="";
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		System.out.println(code);
		
		String response = given().urlEncodingEnabled(false)
                       	  .queryParams("code",code)
                       	  .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                       	  .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                       	  .queryParams("grant_type", "authorization_code")
                       	  .queryParams("state", "verifyfjdss")
                       	  .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                       	  .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                       	  .when().log().all()
                       	  .post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);
		String r2=    given().contentType("application/json").
				 	  queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
				 	  .when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(r2);
		

	
	
	}
	

}
