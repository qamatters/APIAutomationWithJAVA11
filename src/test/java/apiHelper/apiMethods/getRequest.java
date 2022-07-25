package apiHelper.apiMethods;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import static apiHelper.util.commonUtil.createURI;
import static apiHelper.util.commonUtil.createURIForWeatherAPI;

public class getRequest {

    public static HttpResponse getRequest(String env, String endPoint) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .header("accept", "application/json")
                .uri(URI.create(createURI(env, endPoint)))
                .build();
        HttpResponse httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return httpResponse;
    }

    public static HttpResponse getRequestWithAPIKey (String env, String endPoint) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .header("accept", "application/json")
                .header("key", "") //Enter your key here
                .uri(URI.create(createURIForWeatherAPI(env, endPoint)))
                .build();
        HttpResponse httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return httpResponse;
    }

}

