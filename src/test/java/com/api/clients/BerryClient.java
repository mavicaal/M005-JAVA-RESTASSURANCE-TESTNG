// src/main/java/com/test/api/clients/BerryClient.java
package com.api.clients;

import com.api.BaseConfig;
import com.api.models.Berry;
import io.restassured.response.Response;

import java.util.Map;

public class BerryClient {
    private final ApiClient api;

    public BerryClient() {
        BaseConfig.init(); // ensure specs are initialized
        this.api = new ApiClient();
    }

    // BDD-style: given an id, when retrieving a berry, then map to Berry
    public Berry givenBerryId_whenGet_thenReturnBerry(int id) {
        Response res = api.get("/berry/{id}", Map.of(), "id", id);
        return res.as(Berry.class);
    }

    // BDD-style: given a name, when retrieving a berry by name, then map
    public Berry givenBerryName_whenGet_thenReturnBerry(String name) {
        Response res = api.get("/berry/{name}", Map.of(), "name", name);
        return res.as(Berry.class);
    }

    // BDD-style: list berries with pagination
    public Response givenLimitOffset_whenListBerries_thenReturnResponse(int limit, int offset) {
        return api.get("/berry", Map.of("limit", limit, "offset", offset));
    }
}
