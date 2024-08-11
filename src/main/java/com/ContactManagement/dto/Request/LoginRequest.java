package com.ContactManagement.dto.Request;

import lombok.*;
@Setter
@Getter


public class LoginRequest {
    private String userName;
    private String email;
    private String password;
}
