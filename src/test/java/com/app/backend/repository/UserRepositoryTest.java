package com.app.backend.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.backend.model.Role;
import com.app.backend.model.User;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    private String name = "John Doe";
    private String email = "johndoe@email.com";
    private String password = "p@ssw0rd";

    @Test
    public void saveUserTest() {
        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);

        User userCreated = repository.save(user);
        assertEquals(user, userCreated);

        long count = repository.count();
        assertEquals(count, 1, "Expected 1 user, but found " + count);
    }

    @Test
    public void updateUserTest() {
        String newEmail = "john@email.com";

        User user = repository.findByEmail(email).orElse(null);
        assertNotNull(user, "User not found");

        user.setEmail(newEmail);

        User userUpdated = repository.save(user);
        assertEquals(newEmail, userUpdated.getEmail());
    }

    public void findUserTest() {
        User user = repository.findByEmail(email).orElse(null);
        assertNotNull(user, "User not found");
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    public void findAllTest() {
        List<User> users = assertDoesNotThrow(() -> repository.findAll());
        assertFalse(users.isEmpty(), "Could not find all users");
    }

    @Test
    public void deleteUserTest() {
        User user = repository.findByEmail("john@email.com").orElse(null);
        assertNotNull(user, "User not found");

        repository.delete(user);

        long count = repository.count();
        assertEquals(count, 0, "Expected 0 users, but found " + count);
    }

}
