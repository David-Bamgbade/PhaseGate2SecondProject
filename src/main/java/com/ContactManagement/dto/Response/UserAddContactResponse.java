package com.ContactManagement.dto.Response;

import lombok.*;

@Setter
@Getter

public class UserAddContactResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
