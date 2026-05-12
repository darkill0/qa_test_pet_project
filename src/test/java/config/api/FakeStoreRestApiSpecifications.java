package config.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.specification.ResponseSpecification;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public class FakeStoreRestApiSpecifications {
    private static final String URI = "https://fakestoreapi.com/";

    public static void setSpecifications(){
        RestAssured.requestSpecification = new RequestSpecBuilder().setBaseUri(URI).setContentType("application/json").build();
        RestAssured.filters(new AllureRestAssured());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        RestAssured.config = RestAssured.config()
                .objectMapperConfig(
                        objectMapperConfig()
                                .jackson2ObjectMapperFactory((cls, charset) -> objectMapper)
                );

    }

    public static ResponseSpecification responseSpecifications200OK(){
        return new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
    }

    public static ResponseSpecification responseSpecifications400Error(){
        return new ResponseSpecBuilder().expectStatusCode(400).expectContentType("application/json").build();
    }

    public static ResponseSpecification responseSpecificationsCustom(int statusCode, String contentType){
        return new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(contentType).build();
    }

}
