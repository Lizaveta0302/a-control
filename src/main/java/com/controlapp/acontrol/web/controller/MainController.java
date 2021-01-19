package com.controlapp.acontrol.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("GET Response from MainController ", HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<String> greetingForName(@PathVariable String username) {
        return new ResponseEntity<>("Hello from ".concat(username), HttpStatus.OK);
    }
}
