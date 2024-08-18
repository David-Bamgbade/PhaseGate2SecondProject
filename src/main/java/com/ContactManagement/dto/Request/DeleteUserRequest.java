package com.ContactManagement.dto.Request;

import lombok.*;

@Setter
@Getter


public class DeleteUserRequest {
    private String Id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;

}
