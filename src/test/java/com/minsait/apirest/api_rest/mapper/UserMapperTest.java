// package com.minsait.apirest.api_rest.mapper;

// import com.minsait.apirest.api_rest.dto.UserDTO;
// import com.minsait.apirest.api_rest.model.User;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// import java.lang.reflect.InvocationTargetException;

// class UserMapperTest {

// @Test
// void testToDTO() {
// User user = new User();
// user.setId(1L);
// user.setFirstName("Isaac");
// user.setLastName("Gutierrez");
// user.setEmail("isaac@example.com");

// UserDTO dto = UserMapper.toDTO(user);

// assertNotNull(dto);
// assertEquals("Isaac", dto.getFirstName());
// assertEquals("Gutierrez", dto.getLastName());
// assertEquals("isaac@example.com", dto.getEmail());
// }

// @Test
// void testToEntity() {
// UserDTO dto = new UserDTO();
// dto.setFirstName("Isaac");
// dto.setLastName("García");
// dto.setEmail("isaac@example.com");

// User user = UserMapper.toEntity(dto);

// assertNotNull(user);
// assertEquals("Isaac", user.getFirstName());
// assertEquals("García", user.getLastName());
// assertEquals("isaac@example.com", user.getEmail());
// }

// @Test
// void testUpdateEntity() {
// User user = new User();
// user.setId(1L);
// user.setFirstName("OldName");
// user.setLastName("OldLast");
// user.setEmail("old@example.com");

// UserDTO dto = new UserDTO();
// dto.setFirstName("Isaac");
// dto.setLastName("Gutierrez");
// dto.setEmail("isaac@example.com");

// UserMapper.updateEntity(user, dto);

// assertEquals("Isaac", user.getFirstName());
// assertEquals("Gutierrez", user.getLastName());
// assertEquals("isaac@example.com", user.getEmail());
// }

// @Test
// void testPrivateConstructorThrowsException() throws Exception {
// var constructor = UserMapper.class.getDeclaredConstructor();
// constructor.setAccessible(true);

// InvocationTargetException exception =
// assertThrows(InvocationTargetException.class, constructor::newInstance);

// Throwable cause = exception.getCause();
// assertTrue(cause instanceof UnsupportedOperationException);
// assertEquals("Utility class - no instantiation allowed", cause.getMessage());
// }

// }