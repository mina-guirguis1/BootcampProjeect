package com.perficient.bcproj.user.services.impl;

import com.perficient.bcproj.user.model.User;
import com.perficient.bcproj.user.repository.UserRepository;
import com.perficient.bcproj.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> findAllById(Long id) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(User user, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
