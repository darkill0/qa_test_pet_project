package fakestore.api.steps;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.CartPojo;
import fakestore.api.pojo.newCartPojo;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

public class CartsApiSteps {
    private final String PATH = "carts/";

    @Step("тестирование получение корзины товаров по id={id}")
    public void getOneCartById(int id, CartPojo cartPojo){
        CartPojo cartPojoActual = given()
                .when().get(PATH + id)
                .then().body(matchesJsonSchemaInClasspath("schemas/one_cart_schema.json")).spec(FakeStoreRestApiSpecifications.responseSpecifications200OK())
                .log().all().extract().as(CartPojo.class);
        Assertions.assertEquals(cartPojo, cartPojoActual);
    }

    @Step("тестирование получения список товаров в корзине. Должно быть {size}")
    public void getListCart(int size){
        List<CartPojo> cartPojos = given().when()
                .get(PATH)
                .then().body(matchesJsonSchemaInClasspath("schemas/list_cart_schema.json"))
                .spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).extract().jsonPath().getList("", CartPojo.class);

        Assertions.assertEquals(size, cartPojos.size());
    }

    @Step("тестирование получения список товаров в корзине и проверка что он отсортирован по userId")
    public void getListCartAndSortedByUserId(){
        List<CartPojo> cartPojos = given().when()
                .get(PATH)
                .then().body(matchesJsonSchemaInClasspath("schemas/list_cart_schema.json"))
                .spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).extract().jsonPath().getList("", CartPojo.class);
        List<CartPojo> cartPojosSorted = cartPojos;
        cartPojosSorted = cartPojosSorted.stream().sorted(Comparator.comparing(CartPojo::getUserId)).toList();
        Assertions.assertEquals(cartPojosSorted, cartPojos);
    }

    @Step("тестирование добавления новой корзины товара")
    public void postAddNewCart(newCartPojo newCartPojo, CartPojo cartPojoExpected){
        CartPojo cartPojo = given().body(newCartPojo)
                .when().post(PATH)
                .then().log().all().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(201, "application/json")).extract().as(CartPojo.class);
        Assertions.assertEquals(cartPojoExpected, cartPojo);
    }

    @Step("тестирование обновления корзины по id={id}")
    public void putUpdateCartById(int id, newCartPojo newCartPojo, CartPojo cartPojoExpected){
        CartPojo cartPojo = given().body(newCartPojo)
                .when().put(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).extract().as(CartPojo.class);
        Assertions.assertEquals(cartPojoExpected, cartPojo);
    }

    @Step("тестирование удаления корзины по id={id}")
    public void deleteCartById(int id, CartPojo cartPojoExpected){
        CartPojo cartPojo = given()
                .when().delete(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).extract().as(CartPojo.class);
        Assertions.assertEquals(cartPojoExpected, cartPojo);
        Assertions.assertEquals(cartPojoExpected, cartPojo);
    }
}
