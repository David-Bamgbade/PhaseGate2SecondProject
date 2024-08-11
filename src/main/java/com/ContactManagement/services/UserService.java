package com.ContactManagement.services;
import com.ContactManagement.dto.Request.SignupUserRequest;
import com.ContactManagement.dto.Response.DeleteUserResponse;
import com.ContactManagement.dto.Response.SignupUserResponse;
import com.ContactManagement.dto.Response.UpdateEmailResponse;
import com.ContactManagement.dto.Response.UpdatePasswordResponse;

public interface UserService {

    SignupUserResponse signupUser(SignupUserRequest request);

    public long countUsers();

    boolean loginUser(String email, String password);

    public Boolean logoutUser(String email);

    public UpdateEmailResponse updateEmail(String currentEmail, String newEmail);

    public UpdatePasswordResponse updatePassword(String currentPassword, String newPassword);

    public DeleteUserResponse deleteUser(String email);



}
