package apiHelper.test.post.getPost;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import static apiHelper.constants.endPoints.GET_POST_INFORMATION;
import static apiHelper.services.post.getPost.getFieldValuesFormGetRequest;

public class getPostEndPoint {
    @Test
    @Parameters({"env"})
    public static void validateGetPostEndPoint(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValuesFromPostRequest = getFieldValuesFormGetRequest(env,GET_POST_INFORMATION);
        responseValuesFromPostRequest.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
