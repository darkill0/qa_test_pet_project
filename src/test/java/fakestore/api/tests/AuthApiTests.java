package fakestore.api.tests;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.AuthPojo;
import fakestore.api.steps.AuthApiSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("auth_api_tests")
@Tag("fake_store_api")
@DisplayName("[FAKE API] Тестирование auth на Fake Store api")
public class AuthApiTests {
    private static  AuthApiSteps authSteps;
    private final static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOjEsInVzZXIiOiJqb2huZCIsImlhdCI6MTc3ODU1MDY1NX0.553IuPluhEmnIbAqyblRl2oWZAHBfAFWXaMlWza_N_Q";

    @BeforeAll()
    public static void setUp(){
        FakeStoreRestApiSpecifications.setSpecifications();
        authSteps = new AuthApiSteps();
    }

    @Tag("smoke_test")
    @DisplayName("Check unsuccess auth with incorrect login or password")
    @Description("Тестирование неуспешной аунтефикации потому что логин или пароль неправильный")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkUnsuccessAuthWithIncorrectLoginOrPassword(){
        AuthPojo authPojo = new AuthPojo("jonh", "incorrect");
        authSteps.unsuccessAuthWithIncorrectPasswordOrLogin(authPojo);

    }

    @Tag("smoke_test")
    @DisplayName("Check unsuccess auth with not provided login or password")
    @Description("Тестирование неуспешной аунтефикации потому что логин или пароль не предоставлен")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkUnsuccessAuthWithNotProvidedLoginOrPassword(){
        AuthPojo authPojo = new AuthPojo("jonh", "");
        authSteps.unsuccessAuthWithNoProvidedLoginOrPassword(authPojo);

    }

    @Tag("smoke_test")
    @DisplayName("Check success auth")
    @Description("Тестирование успешной аунтефикации")
    @Test
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSuccessAuth(){

        AuthPojo authPojo = new AuthPojo("johnd", "m38rmF$");
        authSteps.successAuth(authPojo, token);

    }

}
