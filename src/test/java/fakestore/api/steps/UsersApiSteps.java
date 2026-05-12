package fakestore.api.steps;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.NewUserPojo;
import fakestore.api.pojo.UserPojo;
import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UsersApiSteps {
    private final String PATH = "users/";

    @Step("Тестирование получения пользователя по id={id}")
    public void getOneUserById(int id, UserPojo userPojoExpected){
        UserPojo userPojo = given()
                .when().get(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/one_user_schema.json"))
                .extract().as(UserPojo.class);
        Assertions.assertEquals(userPojoExpected, userPojo);
    }

    @Step("Тестирование получения списка пользователей размера {size}")
    public void getListUsers(int size){
        List<UserPojo> userPojos = given()
                .when().get(PATH)
                .then().log().all().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK())
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/list_user_schema.json"))
                .extract().jsonPath().getList("", UserPojo.class);
        Assertions.assertEquals(size, userPojos.size());
    }

    @Step("Тестирование получения списка пользователей размера {size} и что он отсортирован по id")
    public void getListUsersAndCheckSort(int size){
        List<UserPojo> userPojos = given()
                .when().get(PATH)
                .then().log().all().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK())
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/list_user_schema.json"))
                .extract().jsonPath().getList("", UserPojo.class);
        List<UserPojo> userPojosSorted = userPojos.stream().sorted(Comparator.comparing(UserPojo::getId)).toList();
        Assertions.assertEquals(userPojosSorted, userPojos);
    }

    @Step("Тестирование добавления нового пользователя")
    public void postAddNewUser(NewUserPojo newUserPojo, int expectedId){
        int id = given().body(newUserPojo)
                .when().post(PATH)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(201, "application/json"))
                .extract().jsonPath().getInt("id");
        Assertions.assertEquals(expectedId, id);
    }

    @Step("Тестирование обновления пользователя по id={id}")
    public void putUpdateUser(int id, NewUserPojo newUserPojo){
        UserPojo userPojo = given().body(newUserPojo)
                .when().put(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).log().all()
                .extract().as(UserPojo.class);
        Assertions.assertEquals(newUserPojo.getUsername(), userPojo.getUsername());
        Assertions.assertEquals(newUserPojo.getEmail(), userPojo.getEmail());
    }

    @Step("Тестирование удаления пользователя по id={id}")
    public void deleteUserById(int id, UserPojo userPojoExpected){
        UserPojo userPojo = given()
                .when().delete(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).log().all()
                .extract().as(UserPojo.class);
        Assertions.assertEquals(userPojoExpected, userPojo);
    }
}
