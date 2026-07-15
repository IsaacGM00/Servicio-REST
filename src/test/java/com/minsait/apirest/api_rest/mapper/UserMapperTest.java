package com.minsait.apirest.api_rest.mapper;

import com.minsait.apirest.api_rest.dto.UserCreateDTO;
import com.minsait.apirest.api_rest.dto.UserDTO;
import com.minsait.apirest.api_rest.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

class UserMapperTest {

    @Test
    void testToDTO() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Isaac");
        user.setLastName("Lopez");
        user.setEmail("isaac@test.com");

        UserDTO dto = UserMapper.toDTO(user);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Isaac", dto.getFirstName());
        assertEquals("Lopez", dto.getLastName());
        assertEquals("isaac@test.com", dto.getEmail());
    }

    @Test
    void testToEntity() {
        UserCreateDTO createDTO = new UserCreateDTO();
        createDTO.setFirstName("Ana");
        createDTO.setLastName("Perez");
        createDTO.setEmail("ana@test.com");

        User user = UserMapper.toEntity(createDTO);

        assertNotNull(user);
        assertNull(user.getId()); // porque el DTO no tiene id
        assertEquals("Ana", user.getFirstName());
        assertEquals("Perez", user.getLastName());
        assertEquals("ana@test.com", user.getEmail());
    }

    @Test
    void testUpdateEntity() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Isaac");
        user.setLastName("Lopez");
        user.setEmail("isaac@test.com");

        UserCreateDTO dto = new UserCreateDTO();
        dto.setFirstName("Isaac Updated");
        dto.setLastName("Lopez Updated");
        dto.setEmail("isaac.updated@test.com");

        UserMapper.updateEntity(user, dto);

        assertEquals("Isaac Updated", user.getFirstName());
        assertEquals("Lopez Updated", user.getLastName());
        assertEquals("isaac.updated@test.com", user.getEmail());
    }

    @Test
    void testPrivateConstructorThrowsException() throws Exception {
        var constructor = UserMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        InvocationTargetException exception = assertThrows(
                InvocationTargetException.class,
                constructor::newInstance);

        // Verificamos que la causa sea la UnsupportedOperationException
        assertTrue(exception.getCause() instanceof UnsupportedOperationException);
        assertEquals("Utility class - no instantiation allowed", exception.getCause().getMessage());
    }

}