package api.tests;

import api.pojo.RegisterPojo;
import api.pojo.UserPojo;
import api.tests.StepsUsersTest.UsersSteps;
import config.RestApiSpecifications;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
@DisplayName("[API] Набор тестов для работы с пользователями")
@Tag(value = "api_users")
@Epic("Users API")
@Feature("Users management")
public class UsersTestApi {

    private static UsersSteps usersSteps;
    @BeforeAll
    public static void setUp()
    {
        usersSteps = new UsersSteps();
        RestAssured.reset();
        RestApiSpecifications.requestSpec();
    }

    @Test
    @DisplayName("Тестирование получения пользователей и проверка что метод возвращает правильные данные для 1 пользователя")
    @Story("Проверка соответсвие первого пользователя на валидность")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование получения пользователей и проверка что метод возвращает правильные данные для 1 пользователя")
    public void checkGetUsers()
    {
        usersSteps.getUsersAndChekOneUser();
    }

    @Test
    @DisplayName("Проверка что ссылка на аватара пользователей содержит в своем пути id пользователя")
    @Story("Проверка что ссылка на аватара пользователей содержит в своем пути id пользователя")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка что ссылка на аватара пользователей содержит в своем пути id пользователя")
    public void checkUsersAvatarsContainsIdUser()
    {
        usersSteps.checkUsersAvatarsContainsIdUser();
    }

    @Test
    @DisplayName("Проверка что почта пользователя оканчивается на @reqres.in")
    @Story("Проверка что почта пользователя оканчивается на @reqres.in")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка что почта пользователя оканчивается на @reqres.in")
    public void testCheckUsersMailLastSuffix()
    {
        usersSteps.checkUsersMailLastSuffix();
    }

    @Test
    @DisplayName("Проверка количество элементов на странице соотвествует колечство в data. data.size k per_page")
    @Story("Проверка количество элементов на странице")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка количество элементов на странице")
    public void testCheckDataSizeEqualPerPageSize()
    {
            usersSteps.checkDataSizeEqualPerPageSize();
    }

    @Test
    @DisplayName("Тестирование получения несуществующего пользователя")
    @Story("Тестирование получения несуществующего пользователяе")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование получения несуществующего пользователя")
    public void testCheckGetUnknownUser()
    {
        usersSteps.checkGetUnknownUser();
    }

    @Test
    @DisplayName("Проверка удаления пользователя по Id")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Удаления пользователя по Id")
    @Owner("Ilya Koltsov")
    public void testDeleteUserById()
    {
        usersSteps.deleteUserById();
        usersSteps.checkHeaders();
    }

    @Test
    @DisplayName("Проверка обновления пользователя")
    @Description("Проверка обновления пользователя")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка обновления пользователя")
    public void testUpdateUser()
    {
        HashMap<String, String> newUser = new HashMap<>();
        newUser.put("name", "test");
        newUser.put("job", "developer");
        usersSteps.updateUserById(newUser);
        usersSteps.checkNewUserUpdateById(newUser);
    }

    @Test
    @DisplayName("Провекра успешной регистрации пользователя")
    @Description("Проверка успешной регистрации пользователя. Передача нового пользователя и проверка полученного токена")
    public void testRegisterUser(){
        RegisterPojo newUser = new RegisterPojo("eve.holt@reqres.in", "pistol");
        usersSteps.checkRegisterUser(newUser);
        usersSteps.checkToken();
    }

    @Test
    @DisplayName("Провекра неуспешной регистрации пользователя")
    @Description("Проверка неуспешной регистрации пользователя. Передача данных без пароля, без email и не существующего пользователя")
    public void testFailedRegisterUser(){
        RegisterPojo newUserWithoutEmail = new RegisterPojo("", "pistol");
        RegisterPojo newUserWithoutPassword = new RegisterPojo("eve.holt@reqres.in", "");
        RegisterPojo newNotExistedUserWithout = new RegisterPojo("test", "pistol");
        usersSteps.checkFailedRegisterUser(newUserWithoutEmail);
        usersSteps.checkFailedRegisterUserWithoutPassword(newUserWithoutPassword);
        usersSteps.checkFailedRegisterNotExistedUser(newNotExistedUserWithout);
    }

    @Test
    @DisplayName("Проверка успешного входа")
    @Description("Проверка успешного входа пользователя и проверка токена")
    @Owner("Ilya Koltsov")
    @Story("Тестирование успешного входа в систему")
    public void testSuccessLogin()
    {
        RegisterPojo loginData = new RegisterPojo("eve.holt@reqres.in", "pistol");
        usersSteps.checkLogin(loginData);
    }

    @Test
    @DisplayName("Проверка неуспешнго входа пользователя")
    @Description("Проверка неуспешнго входа пользователя. Передача данных без пароля, без email и не существующего пользователя")
    @Owner("Ilya Koltsov")
    @Story("Тестирование неуспешного входа в систему")
    public void testFailedLoginUser(){
        RegisterPojo newUserWithoutEmail = new RegisterPojo("", "pistol");
        RegisterPojo newUserWithoutPassword = new RegisterPojo("eve.holt@reqres.in", "");
        RegisterPojo newNotExistedUserWithout = new RegisterPojo("test", "pistol");
        usersSteps.checkFailedLoginNoExistUser(newNotExistedUserWithout);
        usersSteps.checkFailedLoginNoEmail(newUserWithoutEmail);
        usersSteps.checkFailedLoginNoPassword(newUserWithoutPassword);
    }




}
