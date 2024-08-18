package com.ContactManagement.dto.Request;

import lombok.*;

@Setter
@Getter

public class UpdateContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String message;

}
