package com.ContactManagement.dto.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class RemoveContactByNameRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;
}
