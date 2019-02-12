package Files;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
public class ReusableMethods {

    public static Response rewToJson(Response response) {
        String responseText = response.asString();
        JsonPath js = new JsonPath(responseText);
        return response;
    }
    public static Integer getParam(Response response, String param) {
        String responseText = response.asString();
        JsonPath js = new JsonPath(responseText);
       Integer getParam =  js.get(param);
        return getParam;
    }

}
