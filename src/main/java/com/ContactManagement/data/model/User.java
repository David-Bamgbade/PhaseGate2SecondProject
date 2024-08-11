package com.ContactManagement.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter

public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String message;
//    private String name;
//    private String surname;
//    private String phoneNumber;
//    private String address;
//    private String age;
//    private String gender;
    private String userName;

    @Setter
    @Getter
    private boolean loggedIn;


}
