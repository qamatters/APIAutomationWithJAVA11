package apiHelper.test.postCreation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static apiHelper.apiMethods.postRequest.postRequest;

public class createPost {
        @Test @Parameters({"env"})
        public static void validateCreatePostEndPoint(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValuesFromPostRequest = postRequest(env);
        responseValuesFromPostRequest.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
