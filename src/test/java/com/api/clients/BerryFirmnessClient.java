// src/main/java/com/api/clients/BerryFirmnessClient.java
package com.api.clients;

import com.api.BaseConfig;
import com.api.models.BerryFirmness;
import io.restassured.response.Response;

import java.util.Map;

public class BerryFirmnessClient {
    private final ApiClient api;

    public BerryFirmnessClient() {
        BaseConfig.init(); // ensure specs are initialized
        this.api = new ApiClient();
    }

    // BDD-style: given an id, when retrieving berry firmness, then map to BerryFirmness
    public BerryFirmness givenFirmnessId_whenGet_thenReturnFirmness(int id) {
        Response res = api.get("/berry-firmness/{id}", Map.of(), "id", id);
        return res.as(BerryFirmness.class);
    }

    // BDD-style: given a name, when retrieving berry firmness by name, then map
    public BerryFirmness givenFirmnessName_whenGet_thenReturnFirmness(String name) {
        Response res = api.get("/berry-firmness/{name}", Map.of(), "name", name);
        return res.as(BerryFirmness.class);
    }

    // BDD-style: list berry firmnesses with pagination
    public Response givenLimitOffset_whenListFirmnesses_thenReturnResponse(int limit, int offset) {
        return api.get("/berry-firmness", Map.of("limit", limit, "offset", offset));
    }
}
