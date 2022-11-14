package httpMethods;

import org.awaitility.Awaitility;

import java.time.Duration;

public class BookingTests {
    public static void main(String[] args) {
//        for(int i = 0; i< 5 ; i++)
//            if(CreateBooking.createBooking() -- 200)
//        break;
        Awaitility
                .await()
                .atMost(Duration.ofSeconds(30))
                .pollInterval(Duration.ofSeconds(2))
                .until(() -> Booking.createBooking() = 20);
               // .until(() -> Booking.createBooking()= 20);
    }
}
