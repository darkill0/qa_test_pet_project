package reqres.api.tests.StepsProductTest;

import config.api.RestApiSpecifications;
import io.qameta.allure.Step;
import reqres.api.pojo.ProductPojo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ProductSteps {
    @Step("Получение списка товаров")
    public List<ProductPojo> getProducts(){
        return given().spec(RestApiSpecifications.requestSpec())
                .when().get("products")
                .then().extract().jsonPath().getList("data", ProductPojo.class);
    }
    @Step("Сортировка полученного списка по годам")
    public List<ProductPojo> createSortedList(List<ProductPojo> products)
    {
        return products.stream().sorted(Comparator.comparing(ProductPojo::getYear)).collect(Collectors.toList());
    }


}
