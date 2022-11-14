package httpMethods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetRequest {
    @Test
    public  void testGetReq()
    {
      Response response= get("https://reqres.in/api/users?page=2");
              //RestAssured.get("https://reqres.in/api/users?page=2");

      System.out.println(response.asString());
      System.out.println(response.getBody().asString());
      System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
    }
    @Test
    public void testGetRequest2()
    {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("data.id[0]",equalTo(7))//here '0' represents index
                .body("data.first_name",hasItems("Michael","Lindsay"))
                .log().all();
    }
}
