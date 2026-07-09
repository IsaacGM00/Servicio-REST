package com.minsait.apirest.api_rest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.minsait.apirest.api_rest.dto.UserDTO;
import com.minsait.apirest.api_rest.model.User;
import com.minsait.apirest.api_rest.service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1L);
        user.setFirstName("Isaac");
        user.setLastName("García");
        user.setEmail("isaac@example.com");

        userDTO = new UserDTO();
        userDTO.setFirstName("Isaac");
        userDTO.setLastName("García");
        userDTO.setEmail("isaac@example.com");
    }

    @Test
    void testCreateUser() {
        when(userService.createUser(any(User.class))).thenReturn(user);

        UserDTO result = userController.createUser(userDTO);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        assertEquals("García", result.getLastName());
        assertEquals("isaac@example.com", result.getEmail());
        verify(userService, times(1)).createUser(any(User.class));
    }

    @Test
    void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user));

        List<User> result = userController.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("Isaac", result.get(0).getFirstName());
        assertEquals("isaac@example.com", result.get(0).getEmail());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testSearchUserById() {
        when(userService.getUserById(1L)).thenReturn(user);

        User result = userController.searchUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Isaac", result.getFirstName());
        assertEquals("isaac@example.com", result.getEmail());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testUpdateUser() {
        when(userService.updateUser(eq(1L), any(UserDTO.class))).thenReturn(user);

        UserDTO result = userController.updateUser(1L, userDTO);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        assertEquals("García", result.getLastName());
        assertEquals("isaac@example.com", result.getEmail());
        verify(userService, times(1)).updateUser(eq(1L), any(UserDTO.class));
    }

    @Test
    void testDeleteUserById() {
        doNothing().when(userService).deleteUser(1L);

        userController.deleteUserById(1L);

        verify(userService, times(1)).deleteUser(1L);
    }
}