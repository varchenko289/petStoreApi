package io.swagger.petstore.utils;

import io.swagger.petstore.dto.user.User;

import static io.restassured.RestAssured.given;
import static io.swagger.petstore.endpoints.UserServicePath.USER;
import static io.swagger.petstore.endpoints.UserServicePath.USER_BY_USERNAME;
import static java.net.HttpURLConnection.HTTP_OK;

public class UserUtil {

    public static void createNewUserRequest(User newUser) {

        given()
                .log().all()
                .body(newUser)
                .when().post(USER)
                .then()
                .assertThat().statusCode(HTTP_OK);
    }

    public static User getUserByUserName(String userName) {

        return given().
                get(USER_BY_USERNAME, userName)
                .then()
                .assertThat().statusCode(HTTP_OK)
                .extract().as(User.class);

    }

}
