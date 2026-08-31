package tests.api;

import org.api.pojos.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.helpers.Specifications.getSpecifications;
import static org.helpers.Specifications.requestSpecification;
import static org.helpers.Specifications.responseSpecification;


public class BookingTest {

    @Test
    public void createBooking() {
        BookingDates dates = new BookingDates("2025-01-01", "2025-01-10");
        Booking booking = new Booking("Marianna", "Test", 500, true, dates, "Breakfast");

        getSpecifications(requestSpecification("/booking"), responseSpecification(200));

        CreatedBooking created = given()
                .body(booking)
                .log().all()        // ← ЛОГ ЗАПИТУ (додай цей рядок)
                .when()
                .post()
                .then()
                .log().all()
                .extract().as(CreatedBooking.class);

        Assert.assertEquals(created.getBooking().getFirstname(), "Marianna");
    }

    @Test
    public void getBookingList() {
        getSpecifications(requestSpecification("/booking"), responseSpecification(200));
        List<Integer> bookings = given()
                .when()
                .get()
                .then()
                .log().all()
                .extract().jsonPath().getList("bookingid");

        Assert.assertFalse(bookings.isEmpty());

    }

    private String token;

    @BeforeClass
    public void getToken() {
        AuthData authData = new AuthData("admin", "password123");

        getSpecifications(requestSpecification("/auth"), responseSpecification(200));

        token = given()
                .body(authData)
                .when()
                .post()
                .then()
                .extract().as(Token.class)
                .getToken();
    }

    @Test
    public void updateBooking() {
        BookingDates dates = new BookingDates("2025-01-01", "2025-01-10");
        Booking booking = new Booking("Marianna", "Test", 500, true, dates, "Breakfast");

        getSpecifications(requestSpecification("/booking"), responseSpecification(200));
        int id = given()
                .body(booking)
                .when()
                .post()
                .then()
                .extract().as(CreatedBooking.class)
                .getBookingid();          // ← дістали id створеної броні

        Booking updated = new Booking("Anna", "Updated", 999, false, dates, "Lunch");

        getSpecifications(requestSpecification("/booking/" + id), responseSpecification(200));   // URL з id
        Booking result = given()
                .header("Cookie", "token=" + token)   // ← авторизація
                .body(updated)
                .when()
                .put()                                 // ← PUT, повне оновлення
                .then()
                .log().all()
                .extract().as(Booking.class);          // відповідь на PUT — це сам Booking

        Assert.assertEquals(result.getFirstname(), "Anna");   // перевіряємо, що ім'я змінилось
    }

    @Test
    public void deleteBooking() {
        BookingDates dates = new BookingDates("2025-01-01", "2025-01-10");
        Booking booking = new Booking("Marianna", "Test", 500, true, dates, "Breakfast");

        getSpecifications(requestSpecification("/booking"), responseSpecification(200));

        int id = given()
                .body(booking)
                .log().all()
                .when()
                .post()
                .then()
                .extract().as(CreatedBooking.class)
                .getBookingid();

        getSpecifications(requestSpecification("/booking/" + id), responseSpecification(201));
        given()
                .header("Cookie", "token=" + token)
                .when()
                .delete()
                .then()
                .log().all();

        getSpecifications(requestSpecification("/booking/" + id), responseSpecification(404));
        given()
                .when()
                .get()
                .then()
                .log().all();
    }

    @Test
    public void partialUpdateBooking() {
        BookingDates dates = new BookingDates("2025-01-04", "2025-01-10");
        Booking booking = new Booking("Marianna", "Test", 500, true, dates, "Breakfast");

        getSpecifications(requestSpecification("/booking"), responseSpecification(200));
        int id = given()
                .body(booking)
                .when()
                .post()
                .then()
                .extract().as(CreatedBooking.class)
                .getBookingid();

        Map<String, String> partial = Map.of("firstname", "Patched");
        getSpecifications(requestSpecification("/booking/" + id), responseSpecification(200));
        Booking result = given()
                .header("Cookie", "token=" + token)
                .body(partial)
                .when()
                .patch()                 // ← PATCH
                .then()
                .log().all()
                .extract().as(Booking.class);

        Assert.assertEquals(result.getFirstname(), "Patched");
        Assert.assertEquals(result.getLastname(), "Test");
    }


}
