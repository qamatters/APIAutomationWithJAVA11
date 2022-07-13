package apiHelper.apiMethods;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static apiHelper.constants.apiConstants.*;
import static apiHelper.util.commonUtil.createURI;
import static apiHelper.util.commonUtil.readRequestBody;

public class postRequest {

    public static HashMap<String, String> postRequest(String env) throws IOException, InterruptedException {
        String requestBody = readRequestBody("createPost.json");
        HashMap<String, String> responseValues = new HashMap<>();
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(createURI(env, CREATE_POST)))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
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
