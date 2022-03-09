package com.perficient.bcproj.user;

import com.perficient.bcproj.user.controller.UserController;
import com.perficient.bcproj.user.model.User;
import com.perficient.bcproj.user.repository.UserRepository;
import com.perficient.bcproj.user.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@SpringBootTest
public class UserServiceImplTest {

    private static final Long id = 1L;
    private static final String firstName = "Test";
    private static final String lastName = "Person";
    private static final String gender = "Male";
    private static final Integer age = 22;
    private static final String email = "test@example.com";
    private static final String phoneNumber = "123-456-7890";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    User testUser;
    User otherTestUser;

    @BeforeEach
    void setUp() {
        testUser = User.builder()
                .id(1L)
                .firstName("Test")
                .lastName("Person")
                .gender("Male")
                .age(22)
                .email("test@example.com")
                .phoneNumber("123-456-7890")
                .build();

        userRepository.save(testUser);

        otherTestUser = User.builder()
                .id(2L)
                .firstName("Short")
                .lastName("Lasting")
                .gender("Other")
                .age(22)
                .email("test@example.com")
                .phoneNumber("123-456-7890")
                .build();

        userRepository.save(otherTestUser);
    }

    @Test
    void saveUserTest() {

        User retrievedUser = userRepository.findById(1L).orElse(null);

        assertNotNull(retrievedUser);
        assertEquals(id, retrievedUser.getId());
        assertEquals(firstName, retrievedUser.getFirstName());
        assertEquals(lastName, retrievedUser.getLastName());
        assertEquals(gender, retrievedUser.getGender());
        assertEquals(age, retrievedUser.getAge());
        assertEquals(email, retrievedUser.getEmail());
        assertEquals(phoneNumber, retrievedUser.getPhoneNumber());

    }

    @Test
    void getUsersTest() {
        assertThat(userRepository.findAll().size() == 2);
    }

    @Test
    void updateUserTest() {

        User gottenUser = userRepository.getUserById(otherTestUser.getId());
        User updatedUser = User.builder()
                .id(gottenUser.getId())
                .firstName(gottenUser.getFirstName())
                .lastName(gottenUser.getLastName())
                .gender("Female")
                .age(23)
                .email(gottenUser.getEmail())
                .phoneNumber(gottenUser.getPhoneNumber())
                .build();

        userRepository.save(updatedUser);
        updatedUser = userRepository.getUserById(otherTestUser.getId());

        assertThat(updatedUser.getGender().equals("Female"));
        assertThat(updatedUser.getAge().equals(23));

    }

    @Test
    void deleteUserTest() {
        userRepository.deleteById(otherTestUser.getId());
        assertThat(userRepository.findById(otherTestUser.getId()).isEmpty());

    }

}
