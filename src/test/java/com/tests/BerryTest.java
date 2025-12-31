// src/test/java/com/test/tests/BerryTest.java
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
