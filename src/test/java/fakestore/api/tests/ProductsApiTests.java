package fakestore.api.tests;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.NewProductPojo;
import fakestore.api.pojo.ProductPojo;
import fakestore.api.steps.ProductsApiSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fake_store_products_tests")
@Tag("fake_store_api")
@DisplayName("[FAKE API] Тестирование fake store Products")
@Epic("Проверка работы Products api с Fake Store")
public class ProductsApiTests {
    private static ProductsApiSteps productsApiSteps;

    @BeforeAll
    public static void setUp(){
        productsApiSteps = new ProductsApiSteps();
        FakeStoreRestApiSpecifications.setSpecifications();
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование получение одного товара по id")
    @DisplayName("Тестирование get product by id")
    public void shouldContainsOneProductById(){
        productsApiSteps.getOneProduct(1);
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование получение списка товара")
    @DisplayName("Тестирование get products list")
    public void shouldContainsProductsList(){
        productsApiSteps.getAllProductsList();
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование проверки ссылок на картинки в товаров")
    @DisplayName("Check images url in products contains .png")
    public void shouldContainsPngInImageUrl(){
        productsApiSteps.getAllProductsAndCheckListImagesEndsWithPng();
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование создание нового товара")
    @DisplayName("Check create new product")
    public void shouldCreateNewProduct(){
        NewProductPojo newProductPojo = new NewProductPojo("fake title", 102.4F, "test", "test", "test.png");
        productsApiSteps.postCreatedNewProduct(newProductPojo);
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование создание нового товара с неправильной json schema")
    @DisplayName("Check create new product with broken json")
    public void shouldNotCreatedNewProductAndGet400Error(){
        productsApiSteps.postCreateProductWithBrokenJson();
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование обновления товара по id")
    @DisplayName("Check update product by id")
    public void shouldUpdateProductById(){
        NewProductPojo newProductPojo = new NewProductPojo("new fake title", 103.4F, "new test", "new test", "new_test.png");
        productsApiSteps.putUpdateOneProductById(1, newProductPojo);
    }

    @Test
    @Tag("fake_store")
    @Tag("smoke_test")
    @Owner("Ilya Koltsov")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тестирование удаления товара по id")
    @DisplayName("Check delete product by id")
    public void shouldDeleteProductById(){
        ProductPojo productPojoExpected = new ProductPojo(1, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", 109.95F, "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday"
                , "men's clothing", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png", new ProductPojo.RatingPojo(120, 3.9F));
        productsApiSteps.deleteProductById(1, productPojoExpected);
    }
}

