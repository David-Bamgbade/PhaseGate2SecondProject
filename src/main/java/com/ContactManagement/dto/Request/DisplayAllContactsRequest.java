package com.ContactManagement.dto.Request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class DisplayAllContactsRequest {
    private String Id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String gender;
    private String Age;
}

