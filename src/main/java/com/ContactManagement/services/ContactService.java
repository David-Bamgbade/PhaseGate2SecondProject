package com.ContactManagement.services;

import com.ContactManagement.data.model.User;
import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;


public interface ContactService {
   AddContactResponse addContact(AddContactRequest request);
    DisplayAllContactsResponse findAllContacts();
    RemoveAllContactsResponse deleteAllContacts();
    FindContactByEmailResponse findContactByEmail(FindContactByEmailRequest request);

 FindContactByPhoneNumberResponse findContactByPhoneNumber(FindContactByPhoneNumberRequest request);

 FindContactByNameResponse findContactByName(FindContactByNameRequest firstName, FindContactByNameRequest request);
    RemoveContactByPhoneNumberResponse validateAndDeleteContactByPhoneNumber(RemoveContactByPhoneNumberRequest request);

    RemoveContactByNameResponse validateAndDeleteContactByName (RemoveContactByNameRequest firstName, RemoveContactByNameRequest lastName);

    RemoveContactByEmailResponse validateAndDeleteContactByEmail(RemoveContactByEmailRequest request);

    FindContactByAddressResponse findContactByAddress(FindContactByAddressRequest request);

    RemoveContactByAddressResponse validateAndDeleteContactByAddress(RemoveContactByAddressRequest request);

    long countNumberOfContacts();

    UpdateContactResponse updateContact(UpdateContactRequest request, UpdateContactRequest request1);

}
