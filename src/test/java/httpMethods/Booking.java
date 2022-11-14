package httpMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Booking {
    public static int createBooking() {
        int randomNumber = ( int) ((Math.random()*(50 - 1)) +1);
        System.out.println(randomNumber);
        if(randomNumber% 2==0) {
            System.out.println("Booking creating....");
            return RestAssured.given()
                    .body("{\r\n" +
                            "\"firstname\" : \"Jim\", \r\n" +
                            "  \"lastname\" : \"Brown\",\r\n" +
                            "    \"totalprice\" : 111, \r\n" +
                            " \"depositpaid\" - : true, \r\n" +
                            "\"checkin\" : \"2018-01-01\" ,\r\n" +
                            "\"checkout\" : \"2019-01-01\" ,\r\n" +
                            "}")
                    .contentType(ContentType.JSON)
                    .post("https://restful-booker.herokuapp.com/booking")
                    .statusCode();
        }
     else
            System.out.println("Booking creatings...");
            return 0;
        }

    }
