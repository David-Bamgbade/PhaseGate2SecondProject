package com.ContactManagement.dto.Response;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FindContactByAddressResponse {
    private String message;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String gender;
    private String Age;

    public FindContactByAddressResponse(String lastName, String firstName, String email, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
    }

}
