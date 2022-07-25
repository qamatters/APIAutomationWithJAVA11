package apiHelper.apiMethods;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import static apiHelper.util.commonUtil.createURI;
import static apiHelper.util.commonUtil.readRequestBody;

public class postRequest {
    public static HttpResponse postRequest(String env, String endPoint, String request) throws IOException, InterruptedException {
        String requestBody = readRequestBody(request);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(createURI(env, endPoint)))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse;
    }
}
