package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilities {

public	static RequestSpecification req;
	 
	 
	
	public RequestSpecification requestSpecs() throws IOException {
		if(req==null)
			
		{
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		
		req = new RequestSpecBuilder().setBaseUri(readConfig("baseurl")).addQueryParam("key","qaclick123")
				  .addFilter(RequestLoggingFilter.logRequestTo(log))
				  .addFilter(ResponseLoggingFilter.logResponseTo(log))
				  .setContentType(ContentType.JSON).build();
		return req;
		}
		
		return req;
	}
	
	
	public static String readConfig(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Dell\\eclipse-workspace\\com.cucumber.api\\src\\test\\java\\Resources\\global.properties"));
		prop.load(fis);
		String Propvalue = prop.getProperty(key);
		return Propvalue;
	}
	
	
	public static String getJsonpath(Response response,String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
		
	}
	
}
