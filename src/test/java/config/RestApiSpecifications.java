package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class RestApiSpecifications {
    private final static String URI = "https://reqres.in/";
    private final static String PATH = "api/";
    private final static String X_KEY = "x-api-key";
    private final static String API_KEY = "pro_2558d9ef476439f1fbdfe7d6a6f9f3a2e534c71f940ddf7fd7e2787230c8ee24";

    public static void requestSpec()
    {

        RestAssured.requestSpecification = new RequestSpecBuilder().setBaseUri(URI).setBasePath(PATH).addHeader(X_KEY,API_KEY).setContentType("application/json").build();
        RestAssured.filters(new AllureRestAssured());
    }
    public static ResponseSpecification responseSpecOK200()
    {
        return new ResponseSpecBuilder().expectContentType("application/json").expectStatusCode(200).build();
    }

    public static ResponseSpecification responseSpecCustom(int code)
    {
        return new ResponseSpecBuilder().expectStatusCode(code).build();
    }
    public static void setSpecificationsForApi(RequestSpecification requestSpecification, ResponseSpecification responseSpecification)
    {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

}
