package com.ContactManagement.services;

import com.ContactManagement.dto.Request.AddContactRequest;
import com.ContactManagement.dto.Response.*;

import java.util.List;


public interface ContactService {
    AddContactResponse addContact(AddContactRequest request);
    DisplayAllContactsResponse findAllContacts();
    RemoveAllContactsResponse deleteAllContacts();
    List <FindContactByEmailResponse> findContactByEmail(String email);

    List<FindContactByNameResponse> findContactByName(String firstName, String lastName);
    RemoveContactByPhoneNumberResponse validateAndDeleteContactByPhoneNumber(String phoneNumber);

    public List<FindContactByPhoneNumberResponse> findContactByPhoneNumber(String request);

    RemoveContactByNameResponse validateAndDeleteContactByName (String firstName, String lastName);

    RemoveContactByEmailResponse validateAndDeleteContactByEmail(String email);

    List<FindContactByAddressResponse> findContactByAddress(String address);

    RemoveContactByAddressResponse validateAndDeleteContactByAddress(String address);

    long countNumberOfContacts();

    public UpdateContactResponse updateContact(String firstName, String newPhoneNumber, String lastName, String newEmail);

}
