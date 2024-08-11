package com.ContactManagement.services;

import com.ContactManagement.data.model.Contact;
import com.ContactManagement.data.repositories.ContactRepo;
import com.ContactManagement.dto.Request.AddContactRequest;
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
        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setAddress(request.getAddress());
        contact.setPhoneNumber(request.getPhoneNumber());
        contactRepo.save(contact);
        AddContactResponse addContactResponse = new AddContactResponse();
        addContactResponse.setMessage("Successfully added contact");
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
                throw new NullPointerException("Contactlist is empty");
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


    public RemoveContactByPhoneNumberResponse validateAndDeleteContactByPhoneNumber(String phoneNumber) {
        List<Contact> contact = contactRepo.findByPhoneNumber(phoneNumber.toLowerCase());

        RemoveContactByPhoneNumberResponse response = new RemoveContactByPhoneNumberResponse();

        if (contact != null && !contact.isEmpty()) {
            response.setMessage("Contact Deleted");
            contactRepo.deleteByPhoneNumber(phoneNumber);
        }
        else {
            throw new NullPointerException("Contact not found");
        }
        return response;

    }

    public List<FindContactByPhoneNumberResponse> findContactByPhoneNumber(String request) {

        List<Contact> contacts = contactRepo.findByPhoneNumber(request);

        List<FindContactByPhoneNumberResponse> responses = new ArrayList<>();

        for (Contact details : contacts) {
            FindContactByPhoneNumberResponse response = new FindContactByPhoneNumberResponse(
                    details.getLastName(),
                    details.getFirstName(),
                    details.getEmail(),
                    details.getAddress()
            );

            responses.add(response);
        }

        return responses;
    }

    public List<FindContactByNameResponse> findContactByName(String firstName, String lastName) {
        List<Contact> contacts = contactRepo.findContactByFirstNameAndLastName(firstName.toLowerCase(), lastName.toLowerCase());

        List<FindContactByNameResponse> responses = new ArrayList<>();

        for (Contact details : contacts) {
            FindContactByNameResponse response = new FindContactByNameResponse(
                    details.getLastName(),
                    details.getFirstName(),
                    details.getEmail(),
                    details.getAddress()
            );
            responses.add(response);
        }
        return responses;
    }

    public RemoveContactByNameResponse validateAndDeleteContactByName(String firstName, String lastName) {
        RemoveContactByNameResponse response = new RemoveContactByNameResponse();
        List<Contact> contact = contactRepo.findContactByFirstNameAndLastName(firstName.toLowerCase(), lastName.toLowerCase());

        if (contact != null && !contact.isEmpty()) {
            response.setMessage("Contact Deleted");
            contactRepo.deleteContactByFirstNameAndLastName(firstName.toLowerCase(), lastName.toLowerCase());
        }
        else {
           throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public List<FindContactByEmailResponse> findContactByEmail(String email) {
        List<Contact> contacts = contactRepo.findByEmail(email.toLowerCase());
        List<FindContactByEmailResponse> responses = new ArrayList<>();
        for (Contact details : contacts) {
            FindContactByEmailResponse response = new FindContactByEmailResponse(
                    details.getLastName(),
                    details.getFirstName(),
                    details.getEmail(),
                    details.getAddress()
            );
            responses.add(response);
        }
        return responses;
    }

    public RemoveContactByEmailResponse validateAndDeleteContactByEmail(String email) {
        RemoveContactByEmailResponse response = new RemoveContactByEmailResponse();
        response.setMessage("Contact Deleted");
        List<Contact> contact = contactRepo.findByEmail(email.toLowerCase());
        if (contact != null && !contact.isEmpty()) {
            contactRepo.deleteByEmail(email);
        }
        else {
            throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public List<FindContactByAddressResponse> findContactByAddress(String address) {
        List<Contact> contacts = contactRepo.findByAddress(address.toLowerCase());
        List<FindContactByAddressResponse> responses = new ArrayList<>();
        for (Contact details : contacts) {
            FindContactByAddressResponse response = new FindContactByAddressResponse(
                    details.getLastName(),
                    details.getFirstName(),
                    details.getEmail(),
                    details.getAddress()
            );
            responses.add(response);
        }
        return responses;
    }

    public RemoveContactByAddressResponse validateAndDeleteContactByAddress(String address) {
        RemoveContactByAddressResponse response = new RemoveContactByAddressResponse();
        response.setMessage("Contact Deleted");
        List<Contact> contact = contactRepo.findByAddress(address.toLowerCase());
        if (contact != null && !contact.isEmpty()) {
            contactRepo.deleteByAddress(address);
        }
        else {
            throw new NullPointerException("Contact not found");
        }
        return response;
    }

    public long countNumberOfContacts() {
        return contactRepo.count();
    }

    public UpdateContactResponse updateContact(String firstName, String newPhoneNumber, String lastName, String newEmail) {
        List<Contact> contacts = contactRepo.findContactByFirstNameAndLastName(firstName, lastName);
        UpdateContactResponse response = new UpdateContactResponse();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                    contact.getPhoneNumber().equalsIgnoreCase(newPhoneNumber);
                    contact.getEmail().equalsIgnoreCase(newEmail);
                    contactRepo.save(contact);
                    response.setMessage("Contact Updated");
                }
            }
        return response;
    }







}