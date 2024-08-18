package com.ContactManagement.dto.Request;

import lombok.*;

@Setter
@Getter


public class UserAddContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
