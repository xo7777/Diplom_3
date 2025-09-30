package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static constants.Url.*;
import static io.restassured.RestAssured.given;

public class User {

    @Step("Создание пользователя")
    public Response createUser(UserRequest userRequest) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(userRequest)
                .when()
                .post(API_REGISTER_URL);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        given()
                .baseUri(BASE_URL)
                .header("Authorization", accessToken)
                .delete(DELETE_USER_URL);
    }

}
