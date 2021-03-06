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
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.getUserByPhoneNumber(phoneNumber);
    }

    @Override
    public User updateUser(User user, Long id) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setGender(user.getGender());
        existingUser.setPhoneNumber(user.getPhoneNumber());

        // Save updates into repo
        userRepository.save(existingUser);

        return existingUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);

    }
}
