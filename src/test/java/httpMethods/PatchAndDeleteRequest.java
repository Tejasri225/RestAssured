package httpMethods;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PatchAndDeleteRequest {
    @Test
    public void testPatchRequest() {


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
                patch("https://reqres.in/api/users/2").then().
                statusCode(200).log().all();
    }
    @Test
    public void testDeleteRequest()
    {
        when().delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).log().all();
    }
}