package apiHelper.test.weather;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static apiHelper.constants.endPoints.CURRENT_WEATHER;
import static apiHelper.services.weather.getCurrentWeather.getCurrentCityWeather;

public class currentWeather {
    @Test
    @Parameters({"env"})
    public static void validateCurrentWeatherAPIEndPoint(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValuesFromPostRequest = getCurrentCityWeather(env, CURRENT_WEATHER);
        responseValuesFromPostRequest.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
