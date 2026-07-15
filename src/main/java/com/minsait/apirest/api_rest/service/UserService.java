package com.minsait.apirest.api_rest.service;

import com.minsait.apirest.api_rest.dto.UserCreateDTO;
import com.minsait.apirest.api_rest.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, UserCreateDTO userCreateDTO);

    void deleteUser(Long id);
}