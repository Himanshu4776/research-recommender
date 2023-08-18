package com.example.researchrecommender.controller;

import com.example.researchrecommender.dto.UserLogin;
import com.example.researchrecommender.dto.UserRequest;
import com.example.researchrecommender.dto.UserResponse;
import com.example.researchrecommender.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/passwordReset")
    @ResponseStatus(HttpStatus.CREATED)
    public String PasswordReset(@RequestBody UserLogin userUpdate) {
        return userService.updatePassword(userUpdate);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean Login(@RequestBody UserLogin userLogin) {
        return userService.userLoginService(userLogin);
    }
}
