package com.ContactManagement.web;

import com.ContactManagement.data.model.Contact;
import com.ContactManagement.dto.Request.SignupUserRequest;
import com.ContactManagement.dto.Response.SignupUserResponse;
import com.ContactManagement.services.ContactService;
import com.ContactManagement.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpAble {

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
    public ResponseEntity<?> login(@RequestBody SignupUserRequest request) {
        try {
            boolean response = userServiceImpl.loginUser("david@gmail.com", "1234");
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }








}
