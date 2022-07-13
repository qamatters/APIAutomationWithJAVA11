package apiHelper.test.getPost;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static apiHelper.apiMethods.getRequest.getRequest;

public class getPostEndPoint {

    @Test
    @Parameters({"env"})
    public static void validateGetPostEndPoint(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValuesFromPostRequest = getRequest(env);
        responseValuesFromPostRequest.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
