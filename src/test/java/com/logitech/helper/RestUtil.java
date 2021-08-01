package com.logitech.helper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestUtil {

    public static Response getRequest(String endpoint) {
        return given().accept(ContentType.JSON).when().get(endpoint);
    }

}
