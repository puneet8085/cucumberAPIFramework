package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class CommonUtils {
   public static RequestSpecification req;

    //request spec builder with logging feature for request and response
    public RequestSpecification requestSpecification() throws IOException {
        if(req==null) {
            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
            req = new RequestSpecBuilder().addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setBaseUri(readProperties("baseuri")).addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    //Method to read data from properties file
    public String readProperties(String key) throws IOException {
        FileInputStream fis = new FileInputStream("src/main/java/config/default.properties");
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }

    public static String rawToJson(Response response, String key)
    {
        JsonPath js = new JsonPath(response.asString());

        return js.get(key).toString();
    }
}
