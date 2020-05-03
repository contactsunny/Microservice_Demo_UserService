package com.contactsunny.poc.user_microservice_example.controllers;

import com.contactsunny.poc.user_microservice_example.dtos.User;
import com.contactsunny.poc.user_microservice_example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable(value = "id") String userId
    ) {
        User user = userService.getUserById(Integer.parseInt(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
