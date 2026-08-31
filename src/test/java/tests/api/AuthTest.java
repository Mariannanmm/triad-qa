package tests.api;

import org.api.pojos.AuthData;
import org.api.pojos.Token;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.helpers.Specifications.getSpecifications;
import static org.helpers.Specifications.requestSpecification;
import static org.helpers.Specifications.responseSpecification;

public class AuthTest {

    @Test
    public void authFlow() {
        AuthData authData = new AuthData("admin", "password123");

        getSpecifications(requestSpecification("/auth"), responseSpecification(200));

        Token token = given()
                .body(authData)
                .when()
                .post()
                .then()
                .log().all()
                .extract().as(Token.class);

        Assert.assertNotNull(token.getToken());
    }
}