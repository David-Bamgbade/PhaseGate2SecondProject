package com.ContactManagement.dto.Request;

import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter

public class AddContactRequest {
    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
