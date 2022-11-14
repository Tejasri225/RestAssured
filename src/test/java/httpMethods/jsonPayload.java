package httpMethods;

import io.restassured.RestAssured;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class jsonPayload {
        @Test
       public void readJSONfile() throws IOException {

            //read data from local JSON file then store in byte array
            byte[] b = Files.readAllBytes(Paths.get("src/test/resources/payLoad.json"));

            //convert byte array to string
            String bdy = new String(b);

            //base URL
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

            //input details with header and body
            given().header("Content-type", "application/json").body(bdy)

                    //adding post method
                    .when().post("/posts").then().log().all()

                    //verify status code as 201
                    .assertThat().statusCode(201);
        }

}