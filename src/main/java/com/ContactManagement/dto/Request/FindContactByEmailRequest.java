package com.ContactManagement.dto.Request;

import lombok.*;

@Getter
@Setter

public class FindContactByEmailRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;
}

