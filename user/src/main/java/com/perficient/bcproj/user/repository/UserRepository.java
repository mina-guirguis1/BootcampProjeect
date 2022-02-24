package com.perficient.bcproj.user.repository;

import com.perficient.bcproj.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getAllById(Long id);
    User getUserById(long id);
    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);

    void deleteUserById(Long id);
}
