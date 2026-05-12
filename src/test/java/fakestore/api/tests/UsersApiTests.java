package fakestore.api.tests;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.NewUserPojo;
import fakestore.api.pojo.UserPojo;
import fakestore.api.steps.UsersApiSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("users_api_tests")
@DisplayName("[FAKE API] тестирование пользователей Fake api")
public class UsersApiTests {
    private static UsersApiSteps usersApiSteps;
    private static UserPojo userPojo;

    @BeforeAll()
    public static void setUp(){
        FakeStoreRestApiSpecifications.setSpecifications();
        usersApiSteps = new UsersApiSteps();
        userPojo = new UserPojo(1, "john@gmail.com", "johnd", "m38rmF$", new UserPojo.Name("john", "doe"),  "1-570-236-7033", 0,
                new UserPojo.Address("kilcoole", "new road", 7682, "12926-3874",
                        new UserPojo.Address.Geolocation("-37.3159", "81.1496")));
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("Тестирование получение пользователя по id")
    @Description("Тестирование получение пользователя по id")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkShouldGetUserById(){
        int id = 1;
        UserPojo userPojo = new UserPojo(1, "john@gmail.com", "johnd", "m38rmF$", new UserPojo.Name("john", "doe"),  "1-570-236-7033", 0,
                new UserPojo.Address("kilcoole", "new road", 7682, "12926-3874",
                        new UserPojo.Address.Geolocation("-37.3159", "81.1496")));
        usersApiSteps.getOneUserById(1, userPojo);
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("Тестирование получение списка пользователей")
    @Description("Тестирование получение списка пользователей")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkGetListUsers(){

        usersApiSteps.getListUsers(10);
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("Тестирование получение списка пользователей и проверка что он отсортирован")
    @Description("Тестирование получение списка пользователей и проверка что он отсортирован")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkGetListSortedUsers(){

        usersApiSteps.getListUsersAndCheckSort(10);
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("Тестирование добавления нового пользователя")
    @Description("Тестирование добавления нового пользователя")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAddNewUser(){
        NewUserPojo newUserPojo = new NewUserPojo(11, "Test", "Test@email.com", "password");
        usersApiSteps.postAddNewUser(newUserPojo, newUserPojo.getId());
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("Тестирование обновления  пользователя")
    @Description("Тестирование обновления пользователя")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkUpdateUser(){
        NewUserPojo newUserPojo = new NewUserPojo(11, "New Test", "newtest@email.com", "newpassword");
        usersApiSteps.putUpdateUser(1, newUserPojo);
    }

    @Test
    @Tag("smoke_test")
    @DisplayName("Тестирование удаления  пользователя по id")
    @Description("Тестирование удаления  пользователя по id")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    public void checkDeleteUserById(){


        usersApiSteps.deleteUserById(1, userPojo);
    }

}
