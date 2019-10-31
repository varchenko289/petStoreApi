package io.swagger.petstore.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.http.ContentType.JSON;
import static io.swagger.petstore.utils.Constants.HeadersValue.API_KEY;


public class RequestSpecificationUtil {

    private static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private static PropertiesConfig prop = new PropertiesConfig();


    public static void setSpecification() {

        RestAssured.requestSpecification = requestSpecBuilder
                .addHeader(API_KEY, prop.getApiKey())
                .setBaseUri(prop.getBaseUrl())
                .setContentType(JSON)
                .log(io.restassured.filter.log.LogDetail.ALL).build();

    }

}
