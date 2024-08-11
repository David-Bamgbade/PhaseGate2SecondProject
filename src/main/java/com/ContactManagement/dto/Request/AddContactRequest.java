package com.ContactManagement.dto.Request;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AddContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;

}
