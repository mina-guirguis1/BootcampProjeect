package com.perficient.bcproj.demo.services.impl;

import com.perficient.bcproj.demo.model.User;
import com.perficient.bcproj.demo.repository.UserRepository;
import com.perficient.bcproj.demo.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(User user){
        super();
        this.userRepository.save(user);
    }
}
