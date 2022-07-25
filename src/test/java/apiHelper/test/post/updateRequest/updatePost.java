package apiHelper.test.post.updateRequest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static apiHelper.apiMethods.putRequest.putRequest;

public class updatePost {

    @Test
    @Parameters({"env"})
    public static void validateUpdatePostEndPoint(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValuesFromPostRequest = putRequest(env);
        responseValuesFromPostRequest.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
