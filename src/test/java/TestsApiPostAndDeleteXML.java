import Files.PayLoad;
import Files.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static DataLocation.URL.pathToEnv;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestsApiPostAndDeleteXML {
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
        XmlPath xmlPath = new XmlPath(responseText);


    }
}
