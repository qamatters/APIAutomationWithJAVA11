package apiHelper.services.weather;

import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;


import static apiHelper.apiMethods.getRequest.getRequestWithAPIKey;

public class getCurrentWeather {

    public static HashMap<String, String> getCurrentCityWeather(String env, String endPoint) throws IOException, InterruptedException {
        HttpResponse httpResponse = getRequestWithAPIKey(env, endPoint);
        HashMap<String, String> responseValues = new HashMap<>();
        if (httpResponse.statusCode() == 200) {
            String responseValuesAsString = httpResponse.body().toString();
            String name = JsonPath.read(responseValuesAsString, "$.location.name").toString();
            responseValues.put("CurrentCityName", name);
            String rainCondition = JsonPath.read(responseValuesAsString, "$.current.condition.text").toString();
            responseValues.put("RainCondition", rainCondition);
        } else {
            System.out.println("request failed :" + httpResponse);
        }
        return responseValues;
    }
}

