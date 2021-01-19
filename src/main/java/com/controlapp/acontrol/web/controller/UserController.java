package com.controlapp.acontrol.web.controller;

import com.controlapp.acontrol.domain.User;
import com.controlapp.acontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUser(id).orElseThrow());
    }

    @PostMapping("/{id}/{name}")
    public ResponseEntity<User> createUser(@PathVariable long id, @PathVariable String name) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/{name}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @PathVariable String name) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUser(id, name));
    }
}
