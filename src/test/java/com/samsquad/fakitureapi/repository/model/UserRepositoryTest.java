package com.samsquad.fakitureapi.repository.model;

import com.samsquad.fakitureapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Given
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("password");
        userRepository.save(user);

        // When
        User foundUser = userRepository.findByUsername("testUser");

        // Then
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUserName());
        assertEquals("password", foundUser.getPassword());
    }

    @Test
    public void testFindByUsername_NotFound() {
        // Given
        User user = new User();
        user.setUserName("testUser");
        user.setPassword("password");
        userRepository.save(user);

        // When
        User foundUser = userRepository.findByUsername("nonExistingUser");

        // Then
        assertNull(foundUser);
    }

    // Add more test cases as needed
}
