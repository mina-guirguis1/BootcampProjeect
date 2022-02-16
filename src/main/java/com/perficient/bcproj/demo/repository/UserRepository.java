package com.perficient.bcproj.demo.repository;

import com.perficient.bcproj.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findALlById(Long id);

    void deleteUserByID(Long id);
}
