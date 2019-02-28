package Files;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
public class ReusableMethods {

    public static Response rewToJson(Response response) {
        String responseText = response.asString();
        JsonPath js = new JsonPath(responseText);
        return response;
    }
    public static Integer getIntParam(Response response, String param) {
        String responseText = response.asString();
        JsonPath js = new JsonPath(responseText);
        Integer getIntParam =  js.get(param);
        return getIntParam;
    }
    public static String getStringParam(Response response, String param) {
        String responseText = response.asString();
        JsonPath js = new JsonPath(responseText);
        String getIntParam =  js.get(param);
        return getIntParam;
    }

}
