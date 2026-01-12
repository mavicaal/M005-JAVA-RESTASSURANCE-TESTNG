// src/test/java/com/tests/BerryFirmnessTest.java
package com.tests;

import com.api.clients.BerryFirmnessClient;
import com.api.models.BerryFirmness;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BerryFirmnessTest {
    private final BerryFirmnessClient firmnessClient = new BerryFirmnessClient();

    @Test
    void givenValidFirmnessId_whenGetFirmness_thenReturnMappedFirmness() {
        // Given: a known firmness id
        int id = 1;

        // When: retrieving the firmness
        BerryFirmness firmness = firmnessClient.givenFirmnessId_whenGet_thenReturnFirmness(id);

        // Then: verify basic fields
        assertNotNull(firmness);
        assertEquals(1, firmness.getId());
        assertNotNull(firmness.getName());
        assertNotNull(firmness.getBerries());
        assertNotNull(firmness.getNames());
    }

    @Test
    void givenValidFirmnessName_whenGetFirmness_thenReturnMappedFirmness() {
        // Given: a known firmness name
        String name = "soft";

        // When: retrieving the firmness
        BerryFirmness firmness = firmnessClient.givenFirmnessName_whenGet_thenReturnFirmness(name);

        // Then: verify basic fields
        assertNotNull(firmness);
        assertEquals("soft", firmness.getName());
        assertNotNull(firmness.getBerries());
        assertNotNull(firmness.getNames());
    }

    @Test
    void givenLimitOffset_whenListFirmnesses_thenReturnResponse() {
        // Given: limit and offset
        int limit = 5;
        int offset = 0;

        // When: listing berry firmnesses
        Response response = firmnessClient.givenLimitOffset_whenListFirmnesses_thenReturnResponse(limit, offset);

        // Then: verify response
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
