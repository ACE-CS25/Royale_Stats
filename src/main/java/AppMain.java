import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AppMain {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String [] args) throws IOException {

        FileReader reader = new FileReader();

        String playerTag = reader.getPlayerTag();
        String code = reader.getAuthCode();

        System.out.println(playerTag);
        System.out.println(code);

        //create default httpClient
        HttpClient httpClient = HttpClients.createDefault();
        //create http request method object, passing URI as parameter.
        HttpGet httpGet = new HttpGet("https://api.clashroyale.com/v1/players/" + playerTag +"/battlelog");
        //add header to http request for authorization
        httpGet.addHeader("Authorization", code);
        //execute method request and save response into response object
        HttpResponse response = httpClient.execute(httpGet);
        //Extract headers and body from response
        HttpEntity entity = response.getEntity();
        //convert entity to json encoded string
        String strResponse = EntityUtils.toString(entity, StandardCharsets.UTF_8);

        JSONArray battles = new JSONArray(strResponse);
        JSONObject obj = battles.getJSONObject(0);
        System.out.println(response.getStatusLine());
        System.out.println(strResponse);

    }
}
