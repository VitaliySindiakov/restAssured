import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestBody {

    public static String getRegisterBody(){
        String email = getEmail();
        String password = "Ab 1245";
        String userName = "Vitalii" ;
        String registerBody = "{\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"userName\": \""+userName+"\"\n" +
                "}" ;
        return registerBody;
    }

    private static String getEmail(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmSS");
        String date1 = dateFormat.format(date);
        String emailForRegistration = "vitaliiTester.qa" + date1 + "@zwoho.com";
        return emailForRegistration;
    }
}
