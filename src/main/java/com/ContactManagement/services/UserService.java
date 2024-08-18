package com.ContactManagement.services;
import com.ContactManagement.data.model.User;
import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;

public interface UserService {
    public User findByUserId(AddContactRequest addToContactRequest);

    SignupUserResponse signupUser(SignupUserRequest request);

    public long countUsers();

    LoginResponse loginUser(LoginRequest email, LoginRequest password);

     LogoutUserResponse logoutUser(LogoutRequest email);

    public UpdateEmailResponse updateEmail(UpdateEmailRequest request, String newEmail);

    public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request, String newPassword);

    public DeleteUserResponse deleteUser(DeleteUserRequest email);

    AddContactResponse userAddContact(AddContactRequest request);

    RemoveContactByPhoneNumberResponse deleteContactByPhoneNumber(RemoveContactByPhoneNumberRequest request);


}
