package fakestore.api.steps;

import config.api.FakeStoreRestApiSpecifications;
import fakestore.api.pojo.NewProductPojo;
import fakestore.api.pojo.ProductPojo;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProductsApiSteps {
    private final String PATH = "products/";

    @Step("Получение одного товара по {id}")
    public void getOneProduct(int id){
        ProductPojo productPojoExpected = new ProductPojo(1, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", 109.95F, "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday"
        , "men's clothing", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png", new ProductPojo.RatingPojo(120, 3.9F));
        ProductPojo productPojo = given().when().get(PATH+id).then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).log().all().body(matchesJsonSchemaInClasspath("schemas/product_schema.json")).extract().as(ProductPojo.class);
        System.out.println(productPojo);
        Assertions.assertEquals(productPojoExpected, productPojo);
    }

    @Step("Получение и проверка всех товаров в списке. Количество товаров, и соотвествие на json схему")
    public void getAllProductsList(){
        List<ProductPojo> products = given().when().get(PATH).then().body(matchesJsonSchemaInClasspath("schemas/products_schema.json")).extract().jsonPath().getList("", ProductPojo.class);
        Assertions.assertEquals(20, products.size());

    }
    @Step("Проверка что ссылки ссылки на картинки оканчиваются на .png")
    public void getAllProductsAndCheckListImagesEndsWithPng(){
        List<ProductPojo> productPojos = given().
                when().get(PATH)
                .then().log().all().extract().jsonPath().getList("", ProductPojo.class);
        productPojos.forEach(x -> Assertions.assertTrue(x.getImage().endsWith(".png")));
    }

    @Step("Проверка успешного создания товара {newProduct}.")
    public void postCreatedNewProduct(NewProductPojo newProduct){
        ProductPojo productPojo = given().body(newProduct)
                .when().post(PATH)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(201, "application/json"))
                .log().all().extract().as(ProductPojo.class);
        Assertions.assertEquals(newProduct.getTitle(), productPojo.getTitle());
        Assertions.assertEquals(newProduct.getCategory(), productPojo.getCategory());
        Assertions.assertEquals(newProduct.getPrice(), productPojo.getPrice());
        Assertions.assertEquals(newProduct.getDescription(), productPojo.getDescription());
        Assertions.assertEquals(newProduct.getImage(), productPojo.getImage());
    }
    @Step("Проверка создания нового товара с неправильной json схемой")
    public void postCreateProductWithBrokenJson(){
        given().body("{title: 'test")
                .when().post(PATH)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecificationsCustom(400, "text/html; charset=utf-8"));

    }

    @Step("Проверка обновления товара по id={id}")
    public void putUpdateOneProductById(int id, NewProductPojo newProductPojo){
        ProductPojo productPojo = given().body(newProductPojo)
                .when().put(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK())
                .extract().as(ProductPojo.class);
        Assertions.assertEquals(newProductPojo.getTitle(), productPojo.getTitle());
        Assertions.assertEquals(newProductPojo.getCategory(), productPojo.getCategory());
        Assertions.assertEquals(newProductPojo.getPrice(), productPojo.getPrice());
        Assertions.assertEquals(newProductPojo.getDescription(), productPojo.getDescription());
        Assertions.assertEquals(newProductPojo.getImage(), productPojo.getImage());

    }
    @Step("Проверка удаления товара по id={id}")
    public void deleteProductById(int id, ProductPojo productPojo){
        ProductPojo deletedProduct = given().
                when().delete(PATH+id)
                .then().spec(FakeStoreRestApiSpecifications.responseSpecifications200OK()).extract().as(ProductPojo.class);
        Assertions.assertEquals(productPojo, deletedProduct);
    }
}
