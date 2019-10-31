package io.swagger.petstore.utils;

import static io.restassured.RestAssured.given;
import static io.swagger.petstore.endpoints.StoreServicePath.STORE_INVETORY;
import static java.net.HttpURLConnection.HTTP_OK;

public class StoreUtil {

    public static void getInventoryList() {
        given()
                .when().get(STORE_INVETORY)
                .then()
                .log().all()
                .assertThat().statusCode(HTTP_OK);
    }
}
