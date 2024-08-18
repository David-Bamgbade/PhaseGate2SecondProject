package com.ContactManagement.services;

import com.ContactManagement.data.model.User;
import com.ContactManagement.data.repositories.UserRepo;
import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.internal.connection.tlschannel.util.Util.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        userRepo.deleteAll();
    }

    @Test
    public void testToSignUpUser() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("test@test.com");
        request.setPassword("test");
        request.setFirstName("Test");
        request.setLastName("rest");
        request.setAddress("street");
        request.setPhoneNumber("999");
        SignupUserResponse response = userService.signupUser(request);
        assertEquals("Signup successful", response.getMessage());
    }

    @Test
    public void testForUserTOLogin() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("te@te.com");
        request.setPassword("est");
        userService.signupUser(request);
        LoginRequest request1 = new LoginRequest();
        request1.setEmail("te@te.com");
        request1.setPassword("est");
        LoginResponse response = userService.loginUser(request1, request1);
        assertEquals("Login successful", response.getMessage());
    }

    @Test
    public void testForUserTOLogout() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@te.com");
        request.setPassword("oop");
        userService.signupUser(request);
        LoginRequest request1 = new LoginRequest();
        request1.setEmail("tea@te.com");
        request1.setPassword("oop");
        userService.loginUser(request1, request1);
        LogoutRequest request3 = new LogoutRequest();
        request3.setEmail("tea@te.com");
        LogoutUserResponse response = userService.logoutUser(request3);
        assertEquals("Logout successful", response.getMessage());
    }

    @Test
    public void testForUserTOUpdateEmail() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@t.com");
        request.setPassword("oop");
        userService.signupUser(request);
        UpdateEmailRequest request1 = new UpdateEmailRequest();
        request1.setEmail("tea@t.com");
        UpdateEmailResponse response = userService.updateEmail(request1, "test@tet.com");
        assertEquals("Email Updated Successfully", response.getMessage());
    }

    @Test
    public void testForUserTOUpdatePassword() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@t.com");
        request.setPassword("oop");
        userService.signupUser(request);
        UpdatePasswordRequest request1 = new UpdatePasswordRequest();
        request1.setPassword("oop");
        UpdatePasswordResponse response = userService.updatePassword(request1, "pop");
        assertEquals("Password Updated Successfully", response.getMessage());
    }

    @Test
    public void testToDeleteUser() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@te.com");
        request.setPassword("oop");
        userService.signupUser(request);
        DeleteUserRequest request1 = new DeleteUserRequest();
        request1.setEmail("tea@te.com");
        DeleteUserResponse response = userService.deleteUser(request1);
        assertEquals("User Deleted Successfully", response.getMessage());
    }

    @Test
    public void testForUserToAddContact(){
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@te.com");
        request.setPassword("oop");
        request.setFirstName("David");
        request.setLastName("Test");
        request.setAddress("street");
        request.setPhoneNumber("999");
        request.setAge("24");
        request.setGender("male");
        userService.signupUser(request);

        LoginRequest request1 = new LoginRequest();
        request1.setEmail("tea@te.com");
        request1.setPassword("oop");
        userService.loginUser(request1, request1);

        AddContactRequest request3 = new AddContactRequest();
        request3.setEmail("tea@t.com");
        request3.setFirstName("david");
        request3.setLastName("bob");
        request3.setPhoneNumber("90");
        request3.setAddress("main-street");
        AddContactResponse response = userService.userAddContact(request3);
        assertEquals("Contact Added Successfully", response.getMessage());
    }

    @Test
    public void testForUserToDeleteContactByPhoneNumber(){
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@te.com");
        request.setPassword("oop");
        request.setFirstName("David");
        request.setLastName("Test");
        request.setAddress("street");
        request.setPhoneNumber("999");
        request.setAge("24");
        request.setGender("male");
        userService.signupUser(request);

        LoginRequest request1 = new LoginRequest();
        request1.setEmail("tea@te.com");
        request1.setPassword("oop");
        userService.loginUser(request1, request1);

        AddContactRequest request3 = new AddContactRequest();
        request3.setEmail("te.com");
        request3.setFirstName("da");
        request3.setLastName("dob");
        request3.setPhoneNumber("95");
        request3.setAddress("mains-street");
        userService.userAddContact(request3);

        RemoveContactByPhoneNumberRequest request4 = new RemoveContactByPhoneNumberRequest();
        request4.setPhoneNumber("95");

        RemoveContactByPhoneNumberResponse response = userService.deleteContactByPhoneNumber(request4);

        assertEquals("Deleted Successfully", response.getMessage());
    }




}