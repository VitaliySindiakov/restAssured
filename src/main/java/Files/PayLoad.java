package Files;

public class PayLoad {
    public static String getPostData(){
        String bodyText = "{\n" +
                "\"subject\": \"test\",\n" +
                "\"done\": \"1\",\n" +
                "\"type\": \"sport\"\n" +
                "}";
        return bodyText;
    }
}
