package com.minsait.apirest.api_rest.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testUserConstructorAndSetters() {
        // Given
        Long expectedId = 1L;
        String expectedFirstName = "Juan";
        String expectedLastName = "Pérez";
        String expectedEmail = "juan.perez@email.com";

        // When
        user.setId(expectedId);
        user.setFirstName(expectedFirstName);
        user.setLastName(expectedLastName);
        user.setEmail(expectedEmail);

        // Then
        assertEquals(expectedId, user.getId());
        assertEquals(expectedFirstName, user.getFirstName());
        assertEquals(expectedLastName, user.getLastName());
        assertEquals(expectedEmail, user.getEmail());
    }

    @Test
    void testDefaultValues() {
        // Then
        assertNull(user.getId());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
        assertNull(user.getEmail());
    }

    @Test
    void testSetNullValues() {
        // Given
        user.setId(1L);
        user.setFirstName("Juan");
        user.setLastName("Pérez");
        user.setEmail("juan.perez@email.com");

        // When
        user.setId(null);
        user.setFirstName(null);
        user.setLastName(null);
        user.setEmail(null);

        // Then
        assertNull(user.getId());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
        assertNull(user.getEmail());
    }

    @Test
    void testUpdateUserFields() {
        // Given
        user.setId(1L);
        user.setFirstName("Juan");
        user.setLastName("Pérez");
        user.setEmail("juan.perez@email.com");

        // When
        user.setFirstName("Carlos");
        user.setLastName("García");
        user.setEmail("carlos.garcia@email.com");

        // Then
        assertEquals(1L, user.getId()); // ID should remain unchanged
        assertEquals("Carlos", user.getFirstName());
        assertEquals("García", user.getLastName());
        assertEquals("carlos.garcia@email.com", user.getEmail());
    }
}