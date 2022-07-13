package apiHelper.test.deletePost;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import static apiHelper.apiMethods.deleteRequest.deleteRequest;
import static apiHelper.apiMethods.getRequest.getRequest;

public class deletePostEndPoint {
    @Test
    @Parameters({"env"})
    public static void validateDeletePostEndPoint(String env) throws IOException, InterruptedException {
        deleteRequest(env);
    }
}
