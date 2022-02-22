package com.perficient.bcproj.user.controller;


import com.perficient.bcproj.user.model.User;
import com.perficient.bcproj.user.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @GetMapping("/userRepo")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);

    }

}
