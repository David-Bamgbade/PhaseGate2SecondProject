package com.ContactManagement.dto.Response;

import lombok.*;
import org.springframework.data.annotation.Id;


@Setter
@Getter

public class SignupUserResponse {
    @Id
    private String id;
    private String message;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;
    private String userName;

}
