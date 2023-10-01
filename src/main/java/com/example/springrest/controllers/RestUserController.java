package com.example.springrest.controllers;

import com.example.springrest.models.User;
import com.example.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestUserController {

    UserService userService;

    @Autowired
    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> restGetAllUsers() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public User restGetUser(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createNewUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<HttpStatus> removeUser (@PathVariable("id") long id) {
        userService.removeUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable("id") long id, @RequestBody User user){
        userService.updateUserById(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}