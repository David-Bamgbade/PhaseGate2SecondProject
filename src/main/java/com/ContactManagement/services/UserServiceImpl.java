package com.ContactManagement.services;

import com.ContactManagement.data.model.Contact;
import com.ContactManagement.data.model.User;
import com.ContactManagement.data.repositories.UserRepo;
import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ContactServicesImpl contactServices;


    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUserId(AddContactRequest addToContactRequest)
    {
        return userRepo.findByUserId(addToContactRequest.getUserId());
    }

    public SignupUserResponse signupUser(SignupUserRequest request) {
        SignupUserResponse response = new SignupUserResponse();
            User user = new User();
            user.setEmail(request.getEmail().toLowerCase());
            user.setPassword(request.getPassword().toLowerCase());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setAddress(request.getAddress());
            user.setPhoneNumber(request.getPhoneNumber());
            userRepo.save(user);
            response.setMessage("Signup successful");
            response.setFirstName(request.getFirstName().toLowerCase());
            response.setLastName(request.getLastName().toLowerCase());
            response.setAddress(request.getAddress().toLowerCase());
            response.setPhone(request.getPhoneNumber().toLowerCase());
            response.setEmail(request.getEmail().toLowerCase());
            response.setAge(request.getAge().toLowerCase());
            response.setGender(request.getGender().toLowerCase());
        return response;
    }

    public long countUsers() {
        return userRepo.count();
    }

    public LoginResponse loginUser(LoginRequest request, LoginRequest request1) {
        LoginResponse response = new LoginResponse();
        User user = userRepo.findByEmailAndPassword(request.getEmail().toLowerCase(), request1.getPassword().toLowerCase());
        if (user != null && request1.getPassword().equalsIgnoreCase(user.getPassword())) {
            response.setLoggedIn(true);
            userRepo.save(user);
            response.setMessage("Login successful");
        } else {
            throw new IllegalArgumentException("Not a valid email or password");
        }
        return response;
    }

    public LogoutUserResponse logoutUser(LogoutRequest request) {
        User user = userRepo.findByEmail(request.getEmail().toLowerCase());
        LogoutUserResponse response = new LogoutUserResponse();
        if (user != null) {
            response.setLoggedIn(false);
            response.setMessage("Logout successful");
            userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Not a valid email or password");
        }
        return response;
    }

    public UpdateEmailResponse updateEmail(UpdateEmailRequest currentEmail, String newEmail) {
        UpdateEmailResponse response = new UpdateEmailResponse();
        User user = userRepo.findByEmail(currentEmail.getEmail().toLowerCase());
        if (user != null) {
            user.setEmail(newEmail);
            userRepo.save(user);
            response.setMessage("Email Updated Successfully");
        }
        return response;
    }

    public UpdatePasswordResponse updatePassword(UpdatePasswordRequest request, String newPassword) {
        UpdatePasswordResponse response = new UpdatePasswordResponse();
        User user = userRepo.findByPassword(request.getPassword().toLowerCase());
        if (user != null) {
            user.setPassword(newPassword.toLowerCase());
            userRepo.save(user);
            response.setMessage("Password Updated Successfully");
        }
        return response;
    }

    public DeleteUserResponse deleteUser(DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        User user = userRepo.findByEmail(request.getEmail().toLowerCase());
        if (user != null) {
            userRepo.delete(user);
            response.setMessage("User Deleted Successfully");
        }
        return response;
    }

    public AddContactResponse userAddContact(AddContactRequest request) {
        Contact contact = new Contact();

        AddContactResponse response = new AddContactResponse();

        User user = new User();
        user.setEmail(request.getEmail().toLowerCase());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        userRepo.save(user);

       User user1 = userRepo.findByEmail(user.getEmail());
        if (user != null) {
            contact.setEmail(request.getEmail().toLowerCase());
            contact.setFirstName(request.getFirstName());
            contact.setLastName(request.getLastName());
            contact.setPhoneNumber(request.getPhoneNumber());
            contact.setAddress(request.getAddress());
            AddContactResponse newContact = contactServices.addContact(request);
            userRepo.save(user);
            response.setMessage("Contact Added Successfully");
            response.setFirstName(request.getFirstName().toLowerCase());
            response.setLastName(request.getLastName().toLowerCase());
            response.setAddress(request.getAddress().toLowerCase());
            response.setEmail(request.getEmail().toLowerCase());
            response.setPhoneNumber(request.getPhoneNumber().toLowerCase());
            return response;
        } else {
            throw new IllegalArgumentException("Not a valid email or password");
        }
    }

    public RemoveContactByPhoneNumberResponse deleteContactByPhoneNumber(RemoveContactByPhoneNumberRequest request) {
        RemoveContactByPhoneNumberResponse response = new RemoveContactByPhoneNumberResponse();
        Contact contact1 = new Contact();
        User user = userRepo.findByPhoneNumber(request.getPhoneNumber());
        if (user != null) {
            for (Contact contact : user.getListOfContacts()) {
                contact1.setPhoneNumber(contact.getPhoneNumber());
                if (request.getPhoneNumber().equals(contact1.getPhoneNumber())) {
                    user.getListOfContacts().remove(contact1);
                    userRepo.delete(user);
                }
                response.setMessage("Contact Deleted Successful");
            }
        }
        return response;
    }










}





























