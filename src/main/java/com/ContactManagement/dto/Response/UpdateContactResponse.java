package com.ContactManagement.dto.Response;

import lombok.*;
@Setter
@Getter

public class UpdateContactResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
