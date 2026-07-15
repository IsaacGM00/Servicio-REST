package com.minsait.apirest.api_rest.controller;

import com.minsait.apirest.api_rest.dto.UserCreateDTO;
import com.minsait.apirest.api_rest.dto.UserDTO;
import com.minsait.apirest.api_rest.model.User;
import com.minsait.apirest.api_rest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserCreateDTO dto = new UserCreateDTO();
        dto.setFirstName("Isaac");
        dto.setLastName("Lopez");
        dto.setEmail("isaac@test.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setFirstName("Isaac");
        savedUser.setLastName("Lopez");
        savedUser.setEmail("isaac@test.com");

        when(userService.createUser(any(User.class))).thenReturn(savedUser);

        UserDTO result = userController.createUser(dto);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        assertEquals("Lopez", result.getLastName());
        assertEquals("isaac@test.com", result.getEmail());
        verify(userService, times(1)).createUser(any(User.class));
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("Isaac");
        user1.setLastName("Lopez");
        user1.setEmail("isaac@test.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Ana");
        user2.setLastName("Perez");
        user2.setEmail("ana@test.com");

        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("Ana", result.get(1).getFirstName());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testSearchUserById() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Isaac");
        user.setLastName("Lopez");
        user.setEmail("isaac@test.com");

        when(userService.getUserById(1L)).thenReturn(user);

        User result = userController.searchUserById(1L);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        assertEquals("Lopez", result.getLastName());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testUpdateUser() {
        UserCreateDTO dto = new UserCreateDTO();
        dto.setFirstName("Isaac Updated");
        dto.setLastName("Lopez Updated");
        dto.setEmail("isaac.updated@test.com");

        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setFirstName("Isaac Updated");
        updatedUser.setLastName("Lopez Updated");
        updatedUser.setEmail("isaac.updated@test.com");

        when(userService.updateUser(eq(1L), any(UserCreateDTO.class))).thenReturn(updatedUser);

        UserDTO result = userController.updateUser(1L, dto);

        assertEquals("Isaac Updated", result.getFirstName());
        assertEquals("Lopez Updated", result.getLastName());
        assertEquals("isaac.updated@test.com", result.getEmail());
        verify(userService, times(1)).updateUser(eq(1L), any(UserCreateDTO.class));
    }

    @Test
    void testDeleteUserById() {
        doNothing().when(userService).deleteUser(1L);

        userController.deleteUserById(1L);

        verify(userService, times(1)).deleteUser(1L);
    }
}