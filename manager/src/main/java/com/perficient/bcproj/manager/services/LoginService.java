package com.perficient.bcproj.manager.services;

import com.perficient.bcproj.manager.model.Login;

import java.util.List;

public interface LoginService {
    Login createLogin(Login login);
    List<Login> getAllLogins();
    Login getLoginById(Long id);
    Login getLoginByEmail(String email);
    Login updateLogin(Login login, Long id);
    void deleteLogin(Long id);
}
