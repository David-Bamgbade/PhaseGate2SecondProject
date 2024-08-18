package com.ContactManagement.dto.Response;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document
@Getter
@Setter

public class UserDeleteContactByPhoneNumberResponse {
    private String id;
    private String email;
    private String message;
}
