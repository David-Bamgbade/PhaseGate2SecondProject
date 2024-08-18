package com.ContactManagement.dto.Request;

import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter

public class LoginRequest {
    private String email;
    private String password;
}
