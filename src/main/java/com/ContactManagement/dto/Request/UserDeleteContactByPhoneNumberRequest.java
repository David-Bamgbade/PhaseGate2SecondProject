package com.ContactManagement.dto.Request;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document
@Setter
@Getter

public class UserDeleteContactByPhoneNumberRequest {
    private String id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

}
