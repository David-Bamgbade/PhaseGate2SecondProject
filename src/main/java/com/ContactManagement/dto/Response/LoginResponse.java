package com.ContactManagement.dto.Response;

import lombok.*;

@Getter
@Setter

public class LoginResponse {
    private String message;

    public LoginResponse(String message) {
        this.message = message;
    }


}
