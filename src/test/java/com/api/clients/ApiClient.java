// java
// src/test/java/com/api/clients/ApiClient.java
package com.api.clients;

import com.api.BaseConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiClient {

    // Generic GET
    public Response get(String path, Map<String, ?> queryParams, Object... pathParams) {
        return given()
                .spec(BaseConfig.REQUEST_SPEC)
                .pathParams(toPathParams(pathParams))
                .queryParams(queryParams == null ? Map.of() : queryParams)
                .when()
                .get(path)
                .then()
                .spec(BaseConfig.RESPONSE_SPEC)
                .extract()
                .response();
    }

    // Generic GET without query params
    public Response get(String path, Object... pathParams) {
        return get(path, null, pathParams);
    }

    // Generic request for other verbs if needed
    public Response request(Method method, String path, Map<String, ?> queryParams, Object body, Object... pathParams) {
        var req = given().spec(BaseConfig.REQUEST_SPEC)
                .pathParams(toPathParams(pathParams))
                .queryParams(queryParams == null ? Map.of() : queryParams);

        if (body != null) req.body(body);

        return req.request(method, path)
                .then()
                .spec(BaseConfig.RESPONSE_SPEC)
                .extract()
                .response();
    }

    // Helper: convert varargs like ("id", 1, "name", "foo") into a Map<String, Object>
    private Map<String, ?> toPathParams(Object... pathParams) {
        if (pathParams == null || pathParams.length == 0) {
            return Map.of();
        }
        if (pathParams.length % 2 != 0) {
            throw new IllegalArgumentException("pathParams must contain key/value pairs");
        }
        var map = new HashMap<String, Object>(pathParams.length / 2);
        for (int i = 0; i < pathParams.length; i += 2) {
            Object key = pathParams[i];
            Object value = pathParams[i + 1];
            if (!(key instanceof String)) {
                throw new IllegalArgumentException("pathParam keys must be strings");
            }
            map.put((String) key, value);
        }
        return map;
    }
}
