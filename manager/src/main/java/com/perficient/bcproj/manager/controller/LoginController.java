package com.perficient.bcproj.manager.controller;

import com.perficient.bcproj.manager.model.Login;
import com.perficient.bcproj.manager.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/login/")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("loginRepo")
    public ResponseEntity<List<Login>> getAllLogins(){
        log.debug("Getting all logins");
        return new ResponseEntity<List<Login>>(loginService.getAllLogins(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable("id") Long id){
        log.debug("Got user by id");
        return new ResponseEntity<Login>(loginService.getLoginById(id), HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Login> getLoginByEmail(@PathVariable("email") String email){
        log.debug("Got user by email");
        return new ResponseEntity<Login>(loginService.getLoginByEmail(email), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable("id") long id, @RequestBody Login login){
        log.debug("Updated Login");
        return new ResponseEntity<Login>(loginService.updateLogin(login, id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Login> createLogin(@RequestBody Login login){
        log.debug("Created new Login");
        return new ResponseEntity<Login>(loginService.createLogin(login), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteLogin(@PathVariable("id") long id){
        log.debug("Deleting Login");
        loginService.deleteLogin(id);
    }
}
