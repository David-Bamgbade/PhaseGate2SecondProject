package com.ContactManagement.dto.Response;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RemoveContactByNameResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;

}
