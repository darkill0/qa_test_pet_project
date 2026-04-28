package api.tests;

import api.pojo.UserPojo;
import config.RestApiSpecifications;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@Tag(value = "Api тест работы с пользователями")
public class UsersTestApi {

    @BeforeAll
    public static void setUp()
    {
        RestAssured.reset();
        RestApiSpecifications.requestSpec();
    }

    @Test
    @DisplayName("Тестирование получения пользователей и проверка что метод возвращает правильные данные для 1 пользователя")
    public void checkGetUsers()
    {
        UserPojo actualFirstUser = new UserPojo(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg");

        UserPojo findFirstElement = given().when().get("users").then().spec(RestApiSpecifications.responseSpecOK200()).body("data", notNullValue())
                .body("data[0]", notNullValue()).extract().body().jsonPath().getObject("data[0]", UserPojo.class);

        Assertions.assertEquals(actualFirstUser, findFirstElement);


    }

    @Test
    @DisplayName("Проверка что ссылка на аватара пользователей содержит в своем пути id пользователя")
    public void checkUsersAvatarsContainsIdUser()
    {
        List<UserPojo> users = given().
                when()
                .get("users")
                .then().spec(RestApiSpecifications.responseSpecOK200()).log().all().extract().body().jsonPath().getList("data", UserPojo.class);
        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));


    }

    @Test
    @DisplayName("Проверка что почта пользователя оканчивается на @reqres.in")
    public void checkUsersMailLastSuffix()
    {
        List<String> usersEmails = given()
                .when()
                .get("users")
                .then().spec(RestApiSpecifications.responseSpecOK200()).extract().body().jsonPath().getList("data", UserPojo.class).stream().map(UserPojo::getEmail).toList();
        //users.forEach(x -> Assertions.assertTrue(x.getEmail().endsWith("@reqres.in")));
        usersEmails.forEach(x-> Assertions.assertTrue(x.endsWith("@reqres.in")));
    }

    @Test
    @DisplayName("Проверка количество элементов на странице соотвествует колечство в data. data.size k per_page")
    public void checkDataSizeEqualPerPageSize()
    {
        var json = given()
                .when()
                .get("users")
                .then().spec(RestApiSpecifications.responseSpecOK200()).extract().jsonPath();
        int per_page = json.get("per_page");
        List<UserPojo> users = json.getList("data", UserPojo.class);
        Assertions.assertEquals(per_page, users.size());
    }

    @Test
    @DisplayName("Тестирование получения несуществующего пользователя")
    public void checkGetUnknownUser()
    {
        given().when().get("users/1000").then().spec(RestApiSpecifications.responseSpecCustom(404)).log().all();
    }



}
