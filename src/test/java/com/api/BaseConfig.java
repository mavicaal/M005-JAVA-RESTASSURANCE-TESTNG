// src/main/java/com/test/api/BaseConfig.java
package com.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class BaseConfig {
    public static final String BASE_URI = "https://pokeapi.co/api/v2";
    public static RequestSpecification REQUEST_SPEC;
    public static ResponseSpecification RESPONSE_SPEC;

    private BaseConfig() {}

    public static void init() {
        RestAssured.baseURI = BASE_URI;

        REQUEST_SPEC = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RESPONSE_SPEC = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
