package com.ContactManagement.dto.Request;

import lombok.*;

@Setter
@Getter

public class RemoveContactByPhoneNumberRequest {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
