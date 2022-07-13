package apiHelper.apiMethods;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static apiHelper.constants.apiConstants.GET_POST_INFORMATION;
import static apiHelper.util.commonUtil.createURI;

public class deleteRequest {
    public static HashMap<String, String> deleteRequest(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValues = new HashMap<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().DELETE().header("accept", "application/json")
                .uri(URI.create(createURI(env, GET_POST_INFORMATION))).build();
        HttpResponse httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() == 200) {
            System.out.println("the post have been deleted");
        } else {
            System.out.println("request failed :" + httpResponse);
        }
        return responseValues;
    }
}
