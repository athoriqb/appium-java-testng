package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static config.Config.BASE_URI;

public class ApiUtils {
    static {
        RestAssured.baseURI = BASE_URI;
    }
    public static Response getRequestWithParam(String endpoint, String paramName, String paramValue) {
        return RestAssured
                .given()
                .queryParam(paramName, paramValue)
                .when()
                .get(endpoint);
    }
}
