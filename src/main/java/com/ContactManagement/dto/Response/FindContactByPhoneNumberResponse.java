package com.ContactManagement.dto.Response;

import lombok.*;

@Setter
@Getter


public class FindContactByPhoneNumberResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

    public FindContactByPhoneNumberResponse(String message, String firstName, String lastName, String phone, String email, String address) {
        this.message = message;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;

    }

    public FindContactByPhoneNumberResponse(String lastName, String firstName, String email, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
    }

    public FindContactByPhoneNumberResponse() {

    }
}


