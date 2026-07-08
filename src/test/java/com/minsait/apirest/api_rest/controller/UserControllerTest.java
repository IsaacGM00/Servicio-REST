package com.minsait.apirest.api_rest.controller;

import com.minsait.apirest.api_rest.UserService;
import com.minsait.apirest.api_rest.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class); // ahora sí se puede mockear la interfaz
        userController = new UserController(userService);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Isaac");
        user.setLastName("Martínez");
        user.setEmail("isaac@example.com");

        when(userService.createuser(ArgumentMatchers.any(User.class))).thenReturn(user);

        User result = userController.createUser(user);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        assertEquals("Martínez", result.getLastName());
        assertEquals("isaac@example.com", result.getEmail());
        verify(userService, times(1)).createuser(any(User.class));
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(
                new User() {{ setId(1L); setFirstName("Isaac"); setLastName("Martínez"); setEmail("isaac@example.com"); }},
                new User() {{ setId(2L); setFirstName("Ana"); setLastName("López"); setEmail("ana@example.com"); }}
        );
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
        user.setLastName("Martínez");
        user.setEmail("isaac@example.com");

        when(userService.getUserById(1L)).thenReturn(user);

        User result = userController.searchUserById(1L);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testDeleteUserById() {
        doNothing().when(userService).deleteUser(1L);

        userController.deleteUserById(1L);

        verify(userService, times(1)).deleteUser(1L);
    }
}
