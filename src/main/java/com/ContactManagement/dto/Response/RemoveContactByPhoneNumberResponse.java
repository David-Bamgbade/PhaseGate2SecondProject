package com.ContactManagement.dto.Response;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter



public class RemoveContactByPhoneNumberResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
}
