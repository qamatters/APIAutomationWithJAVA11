package apiHelper.services.post;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static apiHelper.apiMethods.getRequest.getRequest;

public class getPost {
    public static HashMap<String, String> getFieldValuesFormGetRequest(String env, String endPoint) throws IOException, InterruptedException {
        HttpResponse httpResponse = getRequest(env,endPoint);
        HashMap<String, String> responseValues = new HashMap<>();
        if (httpResponse.statusCode() == 200) {
            String responseValuesAsString = httpResponse.body().toString();
            String userId = JsonPath.read(responseValuesAsString, "$.userId").toString();
            String title = JsonPath.read(responseValuesAsString, "$.title").toString();
            String id = JsonPath.read(responseValuesAsString, "$.id").toString();
            String body = JsonPath.read(responseValuesAsString, "$.body").toString();
            responseValues.put("userId", userId);
            responseValues.put("title", title);
            responseValues.put("id", id);
            responseValues.put("body", body);
        } else {
            System.out.println("request failed :" + httpResponse);
        }
        return responseValues;
    }
}
