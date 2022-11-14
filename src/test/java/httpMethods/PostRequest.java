package httpMethods;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PostRequest {
    @Test
    public void testPostRequest()
    {
       /* Map<String, Object> map=new HashMap<String,Object>();

        map.put("name","Ram");
        map.put("job","Teacher");
        System.out.println(map);
        //we want to store our information in json format
        JSONObject request=new JSONObject(map);*/
        //Instead of using map we can directly use json obj request
        JSONObject request=new JSONObject();
        request.put("name","Ram");
        request.put("job","Teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").then().
                statusCode(201).log().all();

    }
}
