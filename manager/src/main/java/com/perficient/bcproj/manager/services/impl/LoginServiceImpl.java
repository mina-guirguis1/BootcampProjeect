package com.perficient.bcproj.manager.services.impl;

import com.perficient.bcproj.manager.model.Login;
import com.perficient.bcproj.manager.repository.LoginRepository;
import com.perficient.bcproj.manager.services.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        super();
        this.loginRepository = loginRepository;
    }

    @Override
    public Login createLogin(Login login) {
        // TODO: check that login already exists
        return loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    @Override
    public Login getLoginById(Long id) {
        return loginRepository.getLoginById(id);
    }

    @Override
    public Login getLoginByEmail(String email) {
        return loginRepository.getLoginByEmail(email);
    }

    @Override
    public Login updateLogin(Login login, Long id) {
        Login updateLogin = loginRepository.getLoginById(id);
        updateLogin.setEmail(login.getEmail());
        updateLogin.setPassword(login.getPassword());
        return loginRepository.save(updateLogin);
    }

    @Override
    public void deleteLogin(Long id) {
        loginRepository.deleteLoginById(id);

    }
}
