package com.minsait.apirest.api_rest;

import com.minsait.apirest.api_rest.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);
}