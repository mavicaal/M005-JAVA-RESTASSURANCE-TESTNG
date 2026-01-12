// src/test/java/com/tests/BerryTest.java
package com.tests;

import com.api.clients.BerryClient;
import com.api.models.Berry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BerryTest {

    private static BerryClient berryClient;

    @BeforeAll
    static void setup() {
        berryClient = new BerryClient();
    }

    @Test
    void givenLimitOffset_whenListBerries_thenReturnValidResponse() {
        // Given: limit and offset for pagination
        int limit = 5;
        int offset = 0;
        // When: listing berries
        var response = berryClient.givenLimitOffset_whenListBerries_thenReturnResponse(limit, offset);
        // Then: verify response status and count
        assertEquals(200, response.getStatusCode());
        int count = response.jsonPath().getInt("count");
        assertTrue(count > 0);
        var results = response.jsonPath().getList("results");
        assertNotNull(results);
        assertEquals(limit, results.size());
    }

    @Test
    void givenValidBerryName_whenGetBerry_thenReturnMappedBerry() {
        // Given: a known berry name
        String name = "cheri";
        // When: retrieving the berry
        Berry berry = berryClient.givenBerryName_whenGet_thenReturnBerry(name);
        // Then: verify basic fields
        assertNotNull(berry);
        assertEquals("cheri", berry.getName());
        assertTrue(berry.getGrowthTime() >= 0);
    }

    @Test
    void givenValidBerryId_whenGetBerry_thenReturnMappedBerry() {
        // Given: a known berry id
        int id = 1;
        // When: retrieving the berry
        Berry berry = berryClient.givenBerryId_whenGet_thenReturnBerry(id);
        // Then: verify basic fields
        assertNotNull(berry);
        assertEquals(1, berry.getId());
        assertNotNull(berry.getName());
        assertTrue(berry.getGrowthTime() >= 0);
    }
}
