package com.minsait.apirest.api_rest;

import com.minsait.apirest.api_rest.model.User;
import com.minsait.apirest.api_rest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        User user = new User();
        user.setFirstName("Isaac");
        user.setLastName("García");
        user.setEmail("isaac@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User created = userService.createuser(user);

        assertNotNull(created);
        assertEquals("Isaac", created.getFirstName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("María");
        user.setLastName("López");
        user.setEmail("maria@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User found = userService.getUserById(1L);

        assertNotNull(found);
        assertEquals("María", found.getFirstName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllUsers() {
        User u1 = new User();
        u1.setId(1L);
        u1.setFirstName("Isaac");

        User u2 = new User();
        u2.setId(2L);
        u2.setFirstName("María");

        when(userRepository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}