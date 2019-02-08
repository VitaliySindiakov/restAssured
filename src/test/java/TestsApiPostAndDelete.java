import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Files.Resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static DataLocation.URL.pathToEnv;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestsApiPostAndDelete {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fils = new FileInputStream(pathToEnv);
        prop.load(fils);
        prop.getProperty("HOST");
    }

    @Test
    public void postAndDeleteData()
    {
        RestAssured.baseURI = prop.getProperty("HOST");
        System.out.println("Start with POST metod and URL - "+prop.getProperty("HOST")+Resources.postData());
        Response responsePost = given().
                queryParam("api_token", prop.getProperty("api_token")).
                header("Content-Type", "application/json").
                body(PayLoad.getPostData()).
                when().
                post(Resources.postData()).
                then().
                assertThat().statusCode(201).
                and().
                contentType(ContentType.JSON).
                and().
                body("data.owner_name", equalTo("Виталий S")).
                extract().response();
        String responseText = responsePost.asString();
        System.out.println(responseText);
        JsonPath js = new JsonPath(responseText);
        Integer id = js.get("data.id");
        System.out.println("ID is - "+id);
        System.out.println("Now we will request Delete metod with - "+prop.getProperty("HOST")+Resources.postData() + id);
        Response responseDelete = given().
                queryParam("api_token", "e2169e8bade7cf22e9a4ca8e7b109faf53b17c9a").
                when().
                delete(Resources.postData() + id).
                then().
                assertThat().statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("data.id", equalTo(id)).
                extract().response();
        String responseDeleteString = responseDelete.asString();
        System.out.println(responseDeleteString);
    }

}
