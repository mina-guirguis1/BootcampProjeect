package com.perficient.bcproj.user.repository;

import com.perficient.bcproj.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllById(Long id);

    void deleteUserById(Long id);
}
