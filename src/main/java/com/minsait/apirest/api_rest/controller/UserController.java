package com.minsait.apirest.api_rest.controller;

import org.springframework.web.bind.annotation.*;

import com.minsait.apirest.api_rest.dto.UserDTO;
import com.minsait.apirest.api_rest.mapper.UserMapper;
import com.minsait.apirest.api_rest.model.User;
import com.minsait.apirest.api_rest.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userService.createUser(user);
        return UserMapper.toDTO(savedUser);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User searchUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(id, userDTO);
        return UserMapper.toDTO(updatedUser);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}