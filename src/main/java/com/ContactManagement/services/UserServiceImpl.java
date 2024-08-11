package com.ContactManagement.services;

import com.ContactManagement.data.model.User;
import com.ContactManagement.data.repositories.UserRepo;
import com.ContactManagement.dto.Request.SignupUserRequest;
import com.ContactManagement.dto.Response.DeleteUserResponse;
import com.ContactManagement.dto.Response.SignupUserResponse;
import com.ContactManagement.dto.Response.UpdateEmailResponse;
import com.ContactManagement.dto.Response.UpdatePasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public SignupUserResponse signupUser(SignupUserRequest request) {
        SignupUserResponse response = new SignupUserResponse();
        User user = new User();
        user.setEmail(request.getEmail().toLowerCase());
        user.setPassword(request.getPassword().toLowerCase());
        userRepo.save(user);
        response.setMessage("Signup successful");
        return response;
    }

    public long countUsers() {
        return userRepo.count();
    }

    public boolean loginUser(String email, String password) {
        User user = userRepo.findByEmail(email.toLowerCase());
        if (user != null && user.getPassword().equalsIgnoreCase(password)) {
            user.setLoggedIn(true);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public Boolean logoutUser(String email) {
        User user = userRepo.findByEmail(email.toLowerCase());
        if (user != null && user.isLoggedIn()) {
            user.setLoggedIn(false);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public UpdateEmailResponse updateEmail(String currentEmail, String newEmail) {
        UpdateEmailResponse response = new UpdateEmailResponse();
        User user = userRepo.findByEmail(currentEmail.toLowerCase());
        if (user != null) {
            user.setEmail(newEmail.toLowerCase());
            userRepo.save(user);
            response.setMessage("Email Updated Successfully");
        }
                return response;
    }

    public UpdatePasswordResponse updatePassword(String currentPassword, String newPassword) {
        UpdatePasswordResponse response = new UpdatePasswordResponse();
        User user = userRepo.findByPassword(currentPassword.toLowerCase());
        if (user != null) {
            user.setPassword(newPassword.toLowerCase());
            userRepo.save(user);
            response.setMessage("Password Updated Successfully");
        }
        return response;
    }

    public DeleteUserResponse deleteUser(String email) {
        DeleteUserResponse response = new DeleteUserResponse();
        User user = userRepo.findByEmail(email.toLowerCase());
        if (user != null) {
            userRepo.delete(user);
            response.setMessage("User Deleted Successfully");
        }
        return response;
    }









}






