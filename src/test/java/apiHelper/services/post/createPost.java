package apiHelper.services.post;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static apiHelper.apiMethods.postRequest.postRequest;

public class createPost {
    public static HashMap<String, String> getFieldValuesFormPostRequest(String env, String endPoint, String request) throws IOException, InterruptedException {
        HttpResponse httpResponse = postRequest(env,endPoint,request);
        HashMap<String, String> responseValues = new HashMap<>();
        if (httpResponse.statusCode() == 201) {
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
