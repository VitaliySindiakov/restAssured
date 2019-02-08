import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestsApiPost {

    @Test
    public void postData(){
        String bodyText = "{\n" +
                "\"subject\": \"test\",\n" +
                "\"done\": \"1\",\n" +
                "\"type\": \"sport\"\n" +
                "}";
        RestAssured.baseURI = "https://api.pipedrive.com";
        Response response = given().
                queryParam("api_token", "e2169e8bade7cf22e9a4ca8e7b109faf53b17c9a").
                header("Content-Type", "application/json").
                body(bodyText).
                when().
                post("/v1/activities").
                then().assertThat().statusCode(201).
                and().contentType(ContentType.JSON).
                and().body("data.owner_name", equalTo("Виталий S")).
                extract().response();
        String a = response.asString();
        System.out.println(a);
    }

}
