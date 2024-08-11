package com.ContactManagement.dto.Request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class FindContactByAddressRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;
}

