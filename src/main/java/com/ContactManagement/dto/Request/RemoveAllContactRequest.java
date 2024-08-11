package com.ContactManagement.dto.Request;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RemoveAllContactRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;

}
