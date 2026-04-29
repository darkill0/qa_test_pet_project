package api.tests;

import api.pojo.ProductPojo;
import api.tests.StepsProductTest.ProductSteps;
import config.api.RestApiSpecifications;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("api-products")
@Epic("API Products")
@Feature("API test products")
public class ProductsTestApi {

    private static ProductSteps productSteps;
    @BeforeAll
    public static void setUp()
    {
        RestAssured.reset();
        RestApiSpecifications.requestSpec();
        productSteps = new ProductSteps();
    }

    @Test
    @DisplayName("Проверка получение товаров и проверка содержания и соответсвие схемы JSON")
    @Story("Получение списка товаров")
    @Owner("Ilya Koltsov")
    @Severity(CRITICAL)
    @Description("Тест проверяет, что API возвращает список товаров с корректной структурой и валидными данными")

    public void checkGetProductsAndSchemaJson()
    {
        Allure.step("Отправка GET запроса на /products", () -> {
            Response response =
                    given()
                            .when()
                            .get("products")
                            .then()
                            .spec(RestApiSpecifications.responseSpecOK200())
                            .extract().response();

            Allure.step("Проверка, что тело ответа не пустое", () -> {
                assertNotNull(response.jsonPath().get("data"));
            });

            Allure.step("Проверка первого товара в списке", () -> {
                response.then()
                        .body("data", notNullValue())
                        .body("data[0].id", greaterThan(0))
                        .body("data[0].name", notNullValue())
                        .body("data[0].year", greaterThan(0))
                        .body("data[0].color", notNullValue())
                        .body("data[0].pantone_value", notNullValue());
            });

            Allure.step("Логирование полного ответа", () -> {
                response.then().log().all();
            });
        });


    }
    @Test
    @DisplayName("Получение товаров и проверка что per_page == data.size")
    public void getProductsAndCheckSizeOnPage()
    {
        var json = given()
                .when().get("products")
                .then().spec(RestApiSpecifications.responseSpecOK200())
                .extract().jsonPath();
        int per_page = json.get("per_page");
        int size = json.getList("data", ProductPojo.class).size();
        Assertions.assertEquals(per_page, size);

    }
    @Test
    @DisplayName("Получение одного товара и проверка соответсвие на данных")
    public void getOneProductAndCheckData()
    {
        ProductPojo expectedProduct = new ProductPojo(1, "cerulean", 2000, "#98B2D1", "15-4020");
        ProductPojo actualProduct = given()
                .when().get("products/1")
                .then().spec(RestApiSpecifications.responseSpecOK200())
                .extract().jsonPath().getObject("data", ProductPojo.class);
        Assertions.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    @DisplayName("Получение несуществующего товара")
    public void getOneUnknowProduct()
    {
        given()
                .when().get("products/100")
                .then().spec(RestApiSpecifications.responseSpecCustom(404)).log().all();
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка сортировки данных по годам")
    @Owner("Ilya Koltsov")
    @Description("Получение данных о товаров и проверка что они отдаются в отсортированном формате по годам")
    public void getProductsAndCheckSorted()
    {
        List<ProductPojo> products = productSteps.getProducts();
        List<ProductPojo> sortedProducts = productSteps.createSortedList(products);
        Allure.step("Сравнение полученных списков", () -> {
            Assertions.assertEquals(sortedProducts, products);
        });

    }

}
