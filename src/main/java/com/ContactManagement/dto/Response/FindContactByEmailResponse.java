package com.ContactManagement.dto.Response;

import lombok.*;
@Getter
@Setter

public class FindContactByEmailResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;

}

