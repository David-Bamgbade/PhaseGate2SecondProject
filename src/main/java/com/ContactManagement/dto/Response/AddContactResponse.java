package com.ContactManagement.dto.Response;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter



public class AddContactResponse {
    @Id
    private String getId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String message;
}
