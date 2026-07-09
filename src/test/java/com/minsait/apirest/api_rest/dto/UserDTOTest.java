package com.minsait.apirest.api_rest.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {
    @Test
    void testSettersAndGetters() {
        UserDTO dto = new UserDTO();

        dto.setFirstName("Isaac");
        dto.setLastName("Gutierrez");
        dto.setEmail("isaac@example.com");

        assertEquals("Isaac", dto.getFirstName());
        assertEquals("Gutierrez", dto.getLastName());
        assertEquals("isaac@example.com", dto.getEmail());
    }

    @Test
    void testEmptyDTO() {
        UserDTO dto = new UserDTO();

        assertNull(dto.getFirstName());
        assertNull(dto.getLastName());
        assertNull(dto.getEmail());
    }

    @Test
    void testUpdateValues() {
        UserDTO dto = new UserDTO();

        dto.setFirstName("OldName");
        dto.setLastName("OldLast");
        dto.setEmail("old@example.com");

        dto.setFirstName("Isaac");
        dto.setLastName("Gutierrez");
        dto.setEmail("isaac@example.com");

        assertEquals("Isaac", dto.getFirstName());
        assertEquals("Gutierrez", dto.getLastName());
        assertEquals("isaac@example.com", dto.getEmail());
    }

}