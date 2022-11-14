package httpMethods;

import groovy.lang.DelegatesTo;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PutRequest {
    @Test
    public void testPutRequest() {


        JSONObject request = new JSONObject();
        request.put("name", "Ram");
        request.put("job", "Teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").then().
                statusCode(200).log().all();
    }
}