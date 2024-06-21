package email;

import common.RestClient;
import common.TestUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MailSacService {

    Properties mailSac = new TestUtil().init_Properties("email/mailSac");

    public String emailGenerator(String username){
        String clean_username = username.replaceAll("[-+.^:,`' =]","");
        String emailId = clean_username.concat(TestUtil.getRandomString(3)).concat(mailSac.getProperty("EMAIL_DOMAIN"));
        if(!getInbox(emailId)){
            getInbox(TestUtil.getRandomString(8).toLowerCase().concat(mailSac.getProperty("EMAIL_DOMAIN")));;
            return emailId;
        }
        return emailId;
    }

    public boolean getInbox() {
        String getInboxURL = mailSac.getProperty("INBOX_API");

        // Headers
        Map<String, String> apiKey = new HashMap<>();
        apiKey.put("MailSac-Key", mailSac.getProperty("API_KEY"));

        Response actualResponse = RestClient.doGet(mailSac.getProperty("BASE_API_URL"), "JSON", apiKey, null, getInboxURL, true);
        assert actualResponse != null;
        return actualResponse.statusCode() == 200;
    }

    public boolean getInbox(String email) {
        String getInboxURL = mailSac.getProperty("INBOX_API")+email;

        // Headers
        Map<String, String> apiKey = new HashMap<>();
        apiKey.put("MailSac-Key", mailSac.getProperty("API_KEY"));

        Response actualResponse = RestClient.doGet(mailSac.getProperty("BASE_API_URL"), "JSON", apiKey, null, getInboxURL, true);
        assert actualResponse != null;
        return actualResponse.statusCode() == 200;
    }

    public boolean getInboxMessage(String email) {
        String getMessageUrl = mailSac.getProperty("INBOX_API")+email+mailSac.getProperty("MESSAGES_URL");

        // Headers
        Map<String, String> apiKey = new HashMap<>();
        apiKey.put("MailSac-Key", mailSac.getProperty("API_KEY"));

        Response actualResponse = RestClient.doGet(mailSac.getProperty("BASE_API_URL"), "JSON", apiKey, null, getMessageUrl, true);
        assert actualResponse != null;
        return actualResponse.statusCode() == 200;
    }

}
