package com.perficient.bcproj.user.services;

import com.perficient.bcproj.user.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(User user);

    List<User> findAllById(Long id);

    User getUserById(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);

}