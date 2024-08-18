package com.ContactManagement.web;

import com.ContactManagement.dto.Request.LoginRequest;
import com.ContactManagement.dto.Request.SignupUserRequest;
import com.ContactManagement.dto.Response.LoginResponse;
import com.ContactManagement.dto.Response.SignupUserResponse;
import com.ContactManagement.services.ContactService;
import com.ContactManagement.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpAbleController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/SignUp")
    public ResponseEntity<?> signUp(@RequestBody SignupUserRequest request) {
        try {
            SignupUserResponse response = userServiceImpl.signupUser(request);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request1, LoginRequest request2) {
        if (request2.getPassword() == null || request2.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }
        try {
            LoginResponse response = userServiceImpl.loginUser(request1, request2);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }








}
