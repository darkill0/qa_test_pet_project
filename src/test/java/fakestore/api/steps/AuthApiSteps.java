package fakestore.api.steps;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.AuthPojo;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthApiSteps {
    private final String PATH = "auth/login";

    @Step("Тестирование неуспешного входа потому что логин или пароль неправильный")
    public void unsuccessAuthWithIncorrectPasswordOrLogin(AuthPojo authPojo){
        given().body(authPojo)
                .when().post(PATH)
                .then().log().all().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(401, "text/html"))
                .body(equalTo("username or password is incorrect"));
    }
    @Step("Тестирование неуспешного входа потому что логин или пароль непредоставлен")
    public void unsuccessAuthWithNoProvidedLoginOrPassword(AuthPojo authPojo){
        given().body(authPojo)
                .when().post(PATH)
                .then().log().all().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(400, "text/html"))
                .body(equalTo("username and password are not provided in JSON format"));
    }
    @Step("Тестирование успешного входа")
    public void successAuth(AuthPojo authPojo, String tokenExpected){
        String token = given().body(authPojo)
                .when().post(PATH)
                .then().log().all().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(201, "application/json"))
                .extract().jsonPath().getString("token");
        Assertions.assertEquals(tokenExpected.split("\\.")[0], token.split("\\.")[0]);
    }
}
