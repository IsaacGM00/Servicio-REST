package com.minsait.apirest.api_rest.mapper;

import com.minsait.apirest.api_rest.dto.UserCreateDTO;
import com.minsait.apirest.api_rest.dto.UserDTO;
import com.minsait.apirest.api_rest.model.User;

public class UserMapper {

    // Constructor privado para evitar instanciación
    private UserMapper() {
        throw new UnsupportedOperationException("Utility class - no instantiation allowed");
    }

    // Para salida de datos con id
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    // Para entrada de datos sin id
    public static User toEntity(UserCreateDTO dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static void updateEntity(User user, UserCreateDTO dto) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
    }
}