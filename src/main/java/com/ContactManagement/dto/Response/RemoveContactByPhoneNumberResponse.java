package com.ContactManagement.dto.Response;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter

public class RemoveContactByPhoneNumberResponse {
    @Id
    private String id;
    private String message;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
