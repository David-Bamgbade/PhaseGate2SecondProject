package com.ContactManagement.dto.Request;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class SignupUserRequest {
    @Id
    private String id;
//    private String firstName;
//    private String lastName;
//    private String userName;
    private String password;
    private String email;
//    private String phoneNumber;
//    private String address;
//    private String age;
//    private String gender;
}
