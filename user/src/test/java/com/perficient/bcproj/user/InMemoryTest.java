package com.perficient.bcproj.user;

import com.perficient.bcproj.user.controller.UserController;
import com.perficient.bcproj.user.model.User;
import com.perficient.bcproj.user.repository.UserRepository;
import com.perficient.bcproj.user.services.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes={UserJpaConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryTest {

    User testUser;
    User otherTestUser;

    private static final Long id = 1L;
    private static final String firstName = "Test";
    private static final String lastName = "Person";
    private static final String gender = "Male";
    private static final Integer age = 22;
    private static final String email = "test@example.com";
    private static final String phoneNumber = "123-456-7890";

    @Resource
    private UserService userService;

    @Resource
    private UserRepository userRepository;

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

        userService.createUser(testUser);

        otherTestUser = User.builder()
                .id(2L)
                .firstName("Short")
                .lastName("Lasting")
                .gender("Other")
                .age(22)
                .email("test@example.com")
                .phoneNumber("123-456-7890")
                .build();

        userService.createUser(otherTestUser);
    }

    @Test
    public void givenUser_whenSave_thenGetOk(){
        User retrievedUser = userService.getUserById(1L);

        assertNotNull(retrievedUser);
        assertEquals(id, retrievedUser.getId());
        assertEquals(firstName, retrievedUser.getFirstName());
        assertEquals(lastName, retrievedUser.getLastName());
        assertEquals(gender, retrievedUser.getGender());
        assertEquals(age, retrievedUser.getAge());
        assertEquals(email, retrievedUser.getEmail());
        assertEquals(phoneNumber, retrievedUser.getPhoneNumber());


    }


}
