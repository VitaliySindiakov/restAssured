import Files.Resource;
import Files.Resources;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static DataLocation.URL.pathToData;
import static io.restassured.RestAssured.given;

public class TaskTests {
    Properties properties = new Properties();
    @BeforeMethod
    public void setUp() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(pathToData);
        properties.load(fileInputStream);
    }
    @Test
    public void registerNewUser(){
        RestAssured.baseURI = properties.getProperty("HOST");
        System.out.println("Start with POST method and URL - " + properties.getProperty("HOST") + Resources.postData());
        Response respRegister = given().
                header("Content-type","application/json").
                body(RequestBody.getRegisterBody()).
                when().
                post(Resource.postData()).
                then().
                assertThat().statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                extract().response();
        ReusableMethods.rewToJson(respRegister);
        String responseDeleteString = respRegister.asString();
        String getToken = ReusableMethods.getStringParam(respRegister, "token");
        System.out.println(responseDeleteString);
        System.out.println(getToken);

    }


    //
}
