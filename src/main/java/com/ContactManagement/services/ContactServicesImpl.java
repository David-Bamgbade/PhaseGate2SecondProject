package com.ContactManagement.services;

import com.ContactManagement.data.model.Contact;
import com.ContactManagement.data.model.User;
import com.ContactManagement.data.repositories.ContactRepo;
import com.ContactManagement.data.repositories.UserRepo;
import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServicesImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public ContactServicesImpl(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public AddContactResponse addContact(AddContactRequest request) {
        User user = new User();
        Contact contact = new Contact();
        contact.setId(request.getUserId());
        contact.setFirstName(request.getFirstName().toLowerCase());
        contact.setLastName(request.getLastName().toLowerCase());
        contact.setEmail(request.getEmail().toLowerCase());
        contact.setAddress(request.getAddress().toLowerCase());
        contact.setPhoneNumber(request.getPhoneNumber());
        user.getListOfContacts().add(contact);
        Contact newContact = contactRepo.save(contact);
        AddContactResponse addContactResponse = new AddContactResponse();
        addContactResponse.setGetId(newContact.getId());
        addContactResponse.setMessage("Successfully added contact");
        addContactResponse.setFirstName(request.getFirstName().toLowerCase());
        addContactResponse.setLastName(request.getLastName().toLowerCase());
        addContactResponse.setEmail(request.getEmail().toLowerCase());
        addContactResponse.setAddress(request.getAddress().toLowerCase());
        addContactResponse.setPhoneNumber(request.getPhoneNumber());
        return addContactResponse;
    }

    private void createNewContact(Contact contact) {
        Contact contact1 = new Contact();
        AddContactRequest request = new AddContactRequest();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setAddress(request.getAddress());
        contact.setPhoneNumber(request.getPhoneNumber());
        contactRepo.save(contact1);
    }

    public DisplayAllContactsResponse findAllContacts() {
        Contact contact = new Contact();
        DisplayAllContactsResponse response = new DisplayAllContactsResponse();
        createNewContact(contact);
        for (Contact contacts : contactRepo.findAll()) {
            if (contacts == null) {
                throw new NullPointerException("Contact list is empty");
            } else {
                response.setMessage("All contacts found");
            }
        }
        return response;
    }

    public RemoveAllContactsResponse deleteAllContacts() {
        Contact contact = new Contact();
        AddContactRequest request = new AddContactRequest();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setAddress(request.getAddress());
        contact.setPhoneNumber(request.getPhoneNumber());
        contactRepo.save(contact);
        RemoveAllContactsResponse response = new RemoveAllContactsResponse();
        contactRepo.delete(contact);
        response.setMessage("Successfully deleted all contacts");
        return response;
    }

    @Override
    public FindContactByPhoneNumberResponse findContactByPhoneNumber(FindContactByPhoneNumberRequest request) {
        Contact contact = contactRepo.findByPhoneNumber(request.getPhoneNumber());
        FindContactByPhoneNumberResponse response = new FindContactByPhoneNumberResponse();
        if (contact != null) {
            response.setAddress(contact.getAddress());
            response.setFirstName(contact.getFirstName());
            response.setLastName(contact.getLastName());
            response.setEmail(contact.getEmail());
            response.setPhoneNumber(contact.getPhoneNumber());
            response.setMessage("Contact found");
            return response;
        }
        else{
            throw new NullPointerException("Contact not found");
            }
    }

    public FindContactByNameResponse findContactByName(FindContactByNameRequest request, FindContactByNameRequest request2) {
        Contact contacts = contactRepo.findContactByFirstNameAndLastName(request.getFirstName().toLowerCase(), request2.getLastName().toLowerCase());
        FindContactByNameResponse response = new FindContactByNameResponse();
        if (contacts != null) {
            response.setMessage("Contact found");
            response.setAddress(contacts.getAddress());
            response.setFirstName(contacts.getFirstName());
            response.setLastName(contacts.getLastName());
            response.setEmail(contacts.getEmail());
            response.setPhone(contacts.getPhoneNumber());
        }
        else {
            throw new NullPointerException("Contact not found");
        }
            return response;
    }

    public RemoveContactByNameResponse validateAndDeleteContactByName(RemoveContactByNameRequest request, RemoveContactByNameRequest request2) {
        RemoveContactByNameResponse response = new RemoveContactByNameResponse();
        Contact contact = contactRepo.findContactByFirstNameAndLastName(request.getFirstName().toLowerCase(), request2.getLastName().toLowerCase());
        if (contact != null) {
            response.setMessage("Contact Deleted");
            contactRepo.delete(contact);
        } else {
            throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public FindContactByEmailResponse findContactByEmail(FindContactByEmailRequest request) {
        FindContactByEmailResponse response = new FindContactByEmailResponse();
        Contact contacts = contactRepo.findByEmail(request.getEmail().toLowerCase());
        if (contacts != null) {
            response.setFirstName(contacts.getFirstName());
            response.setLastName(contacts.getLastName());
            response.setEmail(contacts.getEmail());
            response.setPhone(contacts.getPhoneNumber());
            response.setAddress(contacts.getAddress());
            response.setMessage("Contact found");
            return response;
        }
        else{
            throw new NullPointerException("Contact not found");
        }

    }

    public RemoveContactByEmailResponse validateAndDeleteContactByEmail(RemoveContactByEmailRequest request) {
        RemoveContactByEmailResponse response = new RemoveContactByEmailResponse();
        Contact contact = contactRepo.findByEmail(request.getEmail().toLowerCase());
        if (contact != null) {
            contactRepo.delete(contact);
            response.setMessage("Contact Deleted");
        }
        else {
            throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public FindContactByAddressResponse findContactByAddress(FindContactByAddressRequest request) {
        Contact contacts = contactRepo.findByAddress(request.getAddress().toLowerCase());
        FindContactByAddressResponse responses = new FindContactByAddressResponse();
        if (contacts != null) {
            responses.setMessage("Contact found");
            responses.setAddress(contacts.getAddress());
            responses.setFirstName(contacts.getFirstName());
            responses.setLastName(contacts.getLastName());
            responses.setEmail(contacts.getEmail());
            responses.setPhone(contacts.getPhoneNumber());
        }
            else {
                throw new NullPointerException("Contact not found");
        }
        return responses;
    }

    public RemoveContactByAddressResponse validateAndDeleteContactByAddress(RemoveContactByAddressRequest request) {
        RemoveContactByAddressResponse response = new RemoveContactByAddressResponse();
        response.setMessage("Contact Deleted");
        Contact contact = contactRepo.findByAddress(request.getAddress().toLowerCase());
        if (contact != null) {
            contactRepo.delete(contact);
            response.setMessage("Contact Deleted");
         }

        else {
            throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public long countNumberOfContacts() {
        return contactRepo.count();
    }

    public UpdateContactResponse updateContact(UpdateContactRequest validateOldFirstName, UpdateContactRequest validateOldLastName) {
        Contact contacts = contactRepo.findContactByFirstNameAndLastName(validateOldFirstName.getFirstName().toLowerCase(), validateOldLastName.getLastName().toLowerCase());
        UpdateContactRequest newRequest = new UpdateContactRequest();
        UpdateContactResponse response = new UpdateContactResponse();
        if (contacts != null) {
            newRequest.setFirstName(contacts.getFirstName());
            newRequest.setLastName(contacts.getLastName());
            newRequest.setEmail(contacts.getEmail());
            newRequest.setPhoneNumber(contacts.getPhoneNumber());
            newRequest.setAddress(contacts.getAddress());
            contactRepo.save(contacts);
            response.setAddress(newRequest.getAddress());
            response.setFirstName(newRequest.getFirstName());
            response.setLastName(newRequest.getLastName());
            response.setEmail(newRequest.getEmail());
            response.setPhoneNumber(newRequest.getPhoneNumber());
            response.setMessage("Updated Successfully");
        } else {
            throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public RemoveContactByPhoneNumberResponse validateAndDeleteContactByPhoneNumber(RemoveContactByPhoneNumberRequest request){
        RemoveContactByPhoneNumberResponse response = new RemoveContactByPhoneNumberResponse();
        Contact contact = contactRepo.findByPhoneNumber(request.getPhoneNumber().toLowerCase());
        if (contact != null) {
            response.setMessage("Contact Deleted");
            contactRepo.delete(contact);
        }
        else{
            throw new NullPointerException("Contact not found");
        }
        return response;
    }






}