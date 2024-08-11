package com.ContactManagement.dto.Response;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class FindContactByNameResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;


    public FindContactByNameResponse(String lastName, String firstName, String email, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
    }

}


