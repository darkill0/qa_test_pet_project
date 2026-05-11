package reqres.api.tests.StepsUsersTest;

import config.api.RestApiSpecifications;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import reqres.api.pojo.RegisterPojo;
import reqres.api.pojo.UserPojo;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UsersSteps {

    Response response = null;

    @Step("Тестирование получение пользователей и проверка")
    public void getUsersAndChekOneUser()
    {
        UserPojo actualFirstUser = new UserPojo(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg");

        UserPojo findFirstElement = given().when().get("users").then().spec(RestApiSpecifications.responseSpecOK200()).body("data", notNullValue())
                .body("data[0]", notNullValue()).extract().body().jsonPath().getObject("data[0]", UserPojo.class);

        Assertions.assertEquals(actualFirstUser, findFirstElement);
    }

    @Step("Проверка что ссылка аватара содержит Id")
    public void checkUsersAvatarsContainsIdUser()
    {
        List<UserPojo> users = given().
                when()
                .get("users")
                .then().spec(RestApiSpecifications.responseSpecOK200()).log().all().extract().body().jsonPath().getList("data", UserPojo.class);
        users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));


    }

    @Step("Проверка окончания email на @reqres.in")
    public void checkUsersMailLastSuffix() {
        List<String> usersEmails = given()
                .when()
                .get("users")
                .then().spec(RestApiSpecifications.responseSpecOK200()).extract().body().jsonPath().getList("data", UserPojo.class).stream().map(UserPojo::getEmail).toList();
        //users.forEach(x -> Assertions.assertTrue(x.getEmail().endsWith("@reqres.in")));
        usersEmails.forEach(x -> Assertions.assertTrue(x.endsWith("@reqres.in")));
    }


    @Step("Проверка количество элементов на странице соотвествует колечство в data. data.size k per_page")
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

    @Step("Тестирование получения несуществующего пользователя")
    public void checkGetUnknownUser()
    {
        given().when().get("users/1000").then().spec(RestApiSpecifications.responseSpecCustom(404)).log().all();
    }

    @Step("Удаление пользователя и проверка statusCode 204")
    @Attachment(value = "Response", type = "application/json")
    public void deleteUserById()
    {
        response = given()
                .when().delete("users/2")
                .then().spec(RestApiSpecifications.responseSpecCustom(204)).extract().response();
    }

    @Step("Проверка headers")
    public void checkHeaders()
    {
        Assertions.assertEquals(response.getHeaders().getValue("cache-control"), "no-store");
    }

    @Step("Проверка обновления пользователя {name, job}")
    public void updateUserById(HashMap<String, String> newUser)
    {
        response = given().body(newUser)
                .when().put("users/2")
                .then().spec(RestApiSpecifications.responseSpecOK200())
                .extract().response();
    }

    @Step("Проверка что изменения к пользователю применелись и пользователь обновил информацию")
    public void checkNewUserUpdateById(HashMap<String, String> newUser)
    {
        String userName = response.jsonPath().get("name");
        String userJob = response.jsonPath().get("job");
        Assertions.assertEquals(newUser.get("name"), userName);
        Assertions.assertEquals(newUser.get("job"), userJob);
    }

    @Step("Успешная регистрация. Проверка на создание пользователя")
    public void checkRegisterUser(RegisterPojo newUser)
    {
        response = given().body(newUser)
                .when().post("register")
                .then().spec(RestApiSpecifications.responseSpecOK200()).extract().response();
    }

    @Step("Неуспешная регистрация. Проверка передача данных без email")
    public void checkFailedRegisterUser(RegisterPojo newUser)
    {
        given().body(newUser)
                .when().post("register")
                .then().spec(RestApiSpecifications.responseSpecCustom(400)).body("error", equalTo("Missing email or username"));
    }

    @Step("Неуспешная регистрация. Проверка передача данных без password")
    public void checkFailedRegisterUserWithoutPassword(RegisterPojo newUser)
    {
        given().body(newUser)
                .when().post("register")
                .then().spec(RestApiSpecifications.responseSpecCustom(400)).body("error", equalTo("Missing password"));
    }

    @Step("Неуспешная регистрация. Проверка передача данных без password")
    public void checkFailedRegisterNotExistedUser(RegisterPojo newUser)
    {
        given().body(newUser)
                .when().post("register")
                .then().spec(RestApiSpecifications.responseSpecCustom(400)).body("error", equalTo("Note: Only defined users succeed registration"));
    }


    @Step("Успешная регистрация. Проверка получение токена")
    public void checkToken()
    {
        String token = response.jsonPath().getString("token");
        String expected = "QpwL5tke4Pnpja7X4";
        Assertions.assertEquals(expected, token);
    }

    @Step("Успешный вход в систему")
    public void checkLogin(RegisterPojo loginData){
        given().body(loginData)
                .when().post("login")
                .then().spec(RestApiSpecifications.responseSpecOK200()).body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Step("Неуспешный вход в систему. Нет логина")
    public void checkFailedLoginNoEmail(RegisterPojo loginData){
        given().body(loginData)
                .when().post("login")
                .then().spec(RestApiSpecifications.responseSpecCustom(400)).body("error", equalTo("Missing email or username"));
    }

    @Step("Неуспешный вход в систему. Нет пароля")
    public void checkFailedLoginNoPassword(RegisterPojo loginData){
        given().body(loginData)
                .when().post("login")
                .then().spec(RestApiSpecifications.responseSpecCustom(400)).body("error", equalTo("Missing password"));
    }

    @Step("Неуспешный вход в систему. Вход под несуществующем пользователем")
    public void checkFailedLoginNoExistUser(RegisterPojo loginData){
        given().body(loginData)
                .when().post("login")
                .then().spec(RestApiSpecifications.responseSpecCustom(400)).body("error", equalTo("user not found"));
    }

}
