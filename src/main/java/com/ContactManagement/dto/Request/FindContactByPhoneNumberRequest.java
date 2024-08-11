package com.ContactManagement.dto.Request;

import lombok.*;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class FindContactByPhoneNumberRequest {

    private String message;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

}
