package com.perficient.bcproj.manager.repository;

import com.perficient.bcproj.manager.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {
    List<Login> getAllById(Long id);
    Login getLoginById(long id);
    Login getLoginByEmail(String email);
    void deleteLoginById(Long id);
}
