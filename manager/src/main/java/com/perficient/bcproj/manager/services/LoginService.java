package com.perficient.bcproj.manager.services;

import com.perficient.bcproj.manager.model.Login;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface LoginService {
    Login createLogin(Login login);
    List<Login> getAllLogins();
    Login getLoginById(Long id);
    Login getLoginByEmail(String email);
    Login updateLogin(Login login, Long id);
    void deleteLogin(Long id);
}
