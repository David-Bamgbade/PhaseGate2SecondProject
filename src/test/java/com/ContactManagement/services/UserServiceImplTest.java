package com.ContactManagement.services;

import com.ContactManagement.data.model.User;
import com.ContactManagement.data.repositories.UserRepo;
import com.ContactManagement.dto.Request.SignupUserRequest;
import com.ContactManagement.dto.Response.DeleteUserResponse;
import com.ContactManagement.dto.Response.SignupUserResponse;
import com.ContactManagement.dto.Response.UpdateEmailResponse;
import com.ContactManagement.dto.Response.UpdatePasswordResponse;
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

    @Test
    public void testToSignUpUserAddUser() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("test@test.com");
        request.setPassword("test");
        userService.signupUser(request);
        SignupUserResponse response = userService.signupUser(request);
        assertEquals("Signup successful", response.getMessage());
    }

    @Test
    public void testForUserTOLogin() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("te@te.com");
        request.setPassword("est");
        userService.signupUser(request);
        assertTrue(userService.loginUser("te@te.com", "est"));
    }

    @Test
    public void testForUserTOLogout() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@te.com");
        request.setPassword("oop");
        userService.signupUser(request);
        userService.loginUser("tea@te.com", "oop");
        userService.logoutUser("tea@.com");
    }

    @Test
    public void testForUserTOUpdateEmail() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@t.com");
        request.setPassword("oop");
        userService.signupUser(request);
        UpdateEmailResponse response = userService.updateEmail("tea@t.com", "pop");
        assertEquals("Email Updated Successfully", response.getMessage());
    }

    @Test
    public void testForUserTOUpdatePassword() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@t.com");
        request.setPassword("oop");
        userService.signupUser(request);
        UpdatePasswordResponse response = userService.updatePassword("oop", "pop");
        assertEquals("Password Updated Successfully", response.getMessage());
    }

    @Test
    public void testToDeleteUser() {
        SignupUserRequest request = new SignupUserRequest();
        request.setEmail("tea@te.com");
        request.setPassword("oop");
        userService.signupUser(request);
        DeleteUserResponse response = userService.deleteUser("tea@te.com");
        assertEquals("User Deleted Successfully", response.getMessage());
    }


}