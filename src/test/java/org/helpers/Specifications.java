package org.helpers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Specifications — стиль вчителя (як у carsAPI).
 * Ціль API-частини: restful-booker.
 *
 * requestSpecification(url)  -> базовий URI + JSON + Allure-фільтр
 * responseSpecification(code)-> очікуваний статус-код
 * getSpecifications(req,resp)-> ставить обидві специфікації глобально
 *
 * Далі в тестах: getSpecifications(requestSpecification("/booking"),
 *                                  responseSpecification(200));
 * і потім given().body(...).when().post().then()... — методи без аргументів,
 * бо URL і статус уже в специфікаціях.
 */
public class Specifications {

    public static final String BOOKER_URL = "https://restful-booker.herokuapp.com";

    public static RequestSpecification requestSpecification(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(BOOKER_URL + path)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void getSpecifications(RequestSpecification request,
                                         ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
