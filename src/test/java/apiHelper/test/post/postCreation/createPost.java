package apiHelper.test.post.postCreation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import static apiHelper.constants.endPoints.CREATE_POST;
import static apiHelper.services.post.createPost.getFieldValuesFormPostRequest;

public class createPost {
        @Test @Parameters({"env"})
        public static void validateCreatePostEndPoint(String env) throws IOException, InterruptedException {
        HashMap<String, String> responseValuesFromPostRequest = getFieldValuesFormPostRequest(env, CREATE_POST,"createPost.json");
        responseValuesFromPostRequest.forEach((key, value) -> System.out.println(key + " : " + value));
        
    }

}
