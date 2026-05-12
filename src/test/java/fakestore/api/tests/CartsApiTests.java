package fakestore.api.tests;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.CartPojo;
import fakestore.api.pojo.newCartPojo;
import fakestore.api.steps.CartsApiSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Tag("cart_api_tests")
@DisplayName("[API FakeStore] Тестирование корзины товаров")
@Epic("Cart FakeStore Tests")
public class CartsApiTests {
    private static  CartsApiSteps cartsSteps;

    @BeforeAll
    public static void setUp(){
        cartsSteps = new CartsApiSteps();
        FakeStoreRestApiSpecifications.setSpecifications();

    }

    @Test
    @Tag("smoke_test")
    @Tag("fake_store_carts")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка получение корзины товара по id")
    @DisplayName("Проверка получение корзины товара по id")
    public void shouldGetOneCartById(){
        List<CartPojo.Product> products = new ArrayList<>();
        products.add(new CartPojo.Product(1, 4));
        products.add(new CartPojo.Product(2, 1));
        products.add(new CartPojo.Product(3, 6));
        CartPojo cartPojo = new CartPojo(1, 1, Instant.parse("2020-03-02T00:00:00.000Z"), products);
        cartsSteps.getOneCartById(1, cartPojo);
    }

    @Test
    @Tag("smoke_test")
    @Tag("fake_store_carts")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка списка корзины товара по id")
    @DisplayName("Проверка списка корзины товара по id")
    public void shouldGetListCarts(){

        cartsSteps.getListCart(7);
    }

    @Test
    @Tag("smoke_test")
    @Tag("fake_store_carts")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка сортировки списка корзин по UserId")
    @DisplayName("Проверка сортировки списка корзин по UserId")
    public void shouldGetListCartsAndSortedByUserID(){

        cartsSteps.getListCartAndSortedByUserId();
    }

    @Test
    @Tag("smoke_test")
    @Tag("fake_store_carts")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка создания новой корзины товара")
    @DisplayName("Проверка создания новой корзины товара")
    public void shouldAddNewCart(){
        CartPojo.Product product = new CartPojo.Product(1, 3);
        List<CartPojo.Product> products  = new ArrayList<>(List.of(product));
        newCartPojo newCart = new newCartPojo();
        newCart.setUserId(3);
        newCart.setProducts(products);
        CartPojo cartPojo = new CartPojo();
        cartPojo.setId(11);
        cartPojo.setUserId(3);
        cartPojo.setProducts(products);
        cartsSteps.postAddNewCart(newCart, cartPojo);
    }

    @Test
    @Tag("smoke_test")
    @Tag("fake_store_carts")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка обновления корзины товара по id")
    @DisplayName("Проверка обновления корзины товара по id")
    public void shouldUpdateCartById(){
        CartPojo.Product product = new CartPojo.Product(1, 3);
        List<CartPojo.Product> products  = new ArrayList<>(List.of(product));
        newCartPojo newCart = new newCartPojo();
        newCart.setUserId(3);
        newCart.setProducts(products);
        CartPojo cartPojo = new CartPojo();
        cartPojo.setId(1);
        cartPojo.setUserId(3);
        cartPojo.setProducts(products);
        cartsSteps.putUpdateCartById(1, newCart, cartPojo);
    }

    @Test
    @Tag("smoke_test")
    @Tag("fake_store_carts")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка удаления корзины товара по id")
    @DisplayName("Проверка удаления корзины товара по id")
    public void shouldDeleteCartById(){
        List<CartPojo.Product> products = new ArrayList<>();
        products.add(new CartPojo.Product(1, 4));
        products.add(new CartPojo.Product(2, 1));
        products.add(new CartPojo.Product(3, 6));
        CartPojo cartPojo = new CartPojo(1, 1, Instant.parse("2020-03-02T00:00:00.000Z"), products);
        cartsSteps.deleteCartById(1, cartPojo);
    }
}
