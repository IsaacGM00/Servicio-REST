package com.minsait.apirest.api_rest.service;

import com.minsait.apirest.api_rest.dto.UserCreateDTO;
import com.minsait.apirest.api_rest.model.User;
import com.minsait.apirest.api_rest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setFirstName("Isaac");
        user.setLastName("Lopez");
        user.setEmail("isaac@test.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setFirstName("Isaac");
        savedUser.setLastName("Lopez");
        savedUser.setEmail("isaac@test.com");

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.createUser(user);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Isaac", result.getFirstName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Isaac");
        user.setLastName("Lopez");
        user.setEmail("isaac@test.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Isaac", result.getFirstName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserById_NotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getUserById(99L));
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("Isaac");

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Ana");

        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setFirstName("Isaac");
        existingUser.setLastName("Lopez");
        existingUser.setEmail("isaac@test.com");

        UserCreateDTO dto = new UserCreateDTO();
        dto.setFirstName("Isaac Updated");
        dto.setLastName("Lopez Updated");
        dto.setEmail("isaac.updated@test.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User result = userService.updateUser(1L, dto);

        assertEquals("Isaac Updated", result.getFirstName());
        assertEquals("Lopez Updated", result.getLastName());
        assertEquals("isaac.updated@test.com", result.getEmail());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    void testUpdateUser_NotFound() {
        UserCreateDTO dto = new UserCreateDTO();
        dto.setFirstName("Test");

        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.updateUser(99L, dto));
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}