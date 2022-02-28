package com.perficient.bcproj.manager;


import com.perficient.bcproj.manager.controller.LoginController;
import com.perficient.bcproj.manager.model.Login;
import com.perficient.bcproj.manager.repository.LoginRepository;
import com.perficient.bcproj.manager.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@SpringBootTest
public class LoginServiceImplTest {
    private static final Long id = 1L;
    private static final String username = "test@example.com";
    private static final String password = "password";

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginController loginController;

    @MockBean
    private LoginService loginService;

    Login testLogin;
    Login otherTestLogin;

    @BeforeEach
    void setUp(){
        testLogin = Login.builder()
                .id(1L)
                .email("test@example.com")
                .password("password")
                .build();

        loginRepository.save(testLogin);

        otherTestLogin = Login.builder()
                .id(2L)
                .email("joshua.hammer@perficient.com")
                .password("password2")
                .build();

        loginRepository.save(otherTestLogin);
    }

    @Test
    void saveLoginTest(){
        Login retrievedLogin = loginRepository.findById(1L).orElse(null);

        assertNotNull(retrievedLogin);
        assertEquals(id,retrievedLogin.getId());
        assertEquals(username,retrievedLogin.getEmail());
        assertEquals(password,retrievedLogin.getPassword());
    }

    @Test
    void getLoginsTest(){
        assertThat(loginRepository.findAll().size()==2);
    }

    @Test
    void updateLoginTest(){
        Login gottenLogin = loginRepository.getLoginById(testLogin.getId());
        Login updatedLogin = Login.builder()
                .id(gottenLogin.getId())
                .email(gottenLogin.getEmail())
                .password("Password1")
                .build();

        loginRepository.save(updatedLogin);
        updatedLogin = loginRepository.getLoginById(gottenLogin.getId());

        assertThat(updatedLogin.getPassword().equals("Password1"));
    }
    @Test
    void deleteLoginTest(){
        loginRepository.deleteById(testLogin.getId());
        assertThat(loginRepository.findById(testLogin.getId()).isEmpty());
    }


}
