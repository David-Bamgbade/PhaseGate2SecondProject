package com.ContactManagement.services;

import com.ContactManagement.data.repositories.ContactRepo;
import com.ContactManagement.dto.Request.AddContactRequest;
import com.ContactManagement.dto.Request.FindContactByPhoneNumberRequest;
import com.ContactManagement.dto.Response.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServicesTest {

    @Autowired
    private ContactService contactService;



    @Autowired
    private ContactRepo contactRepo;

    @Test
    public void testThatContactIsAdded() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("John");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("9090990");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        AddContactResponse addContactResponse = contactService.addContact(addContactRequest);
        assertEquals(addContactResponse.getMessage(), "Successfully added contact");
    }

    @Test
    public void testToFindAllContacts(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("John");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("9090990");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        DisplayAllContactsResponse response = contactService.findAllContacts();
        contactService.findAllContacts();
        assertEquals(response.getMessage(), "All contacts found");
    }

    @Test
    public void testToDeleteAllContact(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("John");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("9090990");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        RemoveAllContactsResponse response = contactService.deleteAllContacts();
        assertEquals("Successfully deleted all contacts", response.getMessage());
    }

    @Test
    public void testToDeleteContactByPhoneNumber(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("John");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("909");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        contactService.validateAndDeleteContactByPhoneNumber("909");
    }

    @Test
    public void testToFindContactByPhoneNumber(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("John");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("9");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        FindContactByPhoneNumberRequest request = new FindContactByPhoneNumberRequest();
        request.setPhoneNumber("9");
        contactService.findContactByPhoneNumber(request.getPhoneNumber());
    }

    @Test
    public void testToFindContactByName(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("face");
        addContactRequest.setPhoneNumber("9");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        contactService.findContactByName("two", "face");
    }

    @Test
    public void testToFindDeleteContactByName(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("ways");
        addContactRequest.setPhoneNumber("9");
        addContactRequest.setEmail("john@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        contactService.validateAndDeleteContactByName("two", "ways");
    }

    @Test
    public void testToDeleteContactByEmail(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("way");
        addContactRequest.setPhoneNumber("9");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        RemoveContactByEmailResponse response = new RemoveContactByEmailResponse();
        contactService.validateAndDeleteContactByEmail("john@do.com");
    }

    @Test
    public void testToFindContactByEmail(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("way");
        addContactRequest.setPhoneNumber("9");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        contactService.findContactByEmail("john@do.com");
    }

    @Test
    public void testToFindContactByAddress(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("wayy");
        addContactRequest.setPhoneNumber("90");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("123 St");
        contactService.addContact(addContactRequest);
        contactService.findContactByAddress("123 St");
    }

    @Test
    public void testToDeleteContactByAddress(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("way");
        addContactRequest.setPhoneNumber("19");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("123 str");
        contactService.addContact(addContactRequest);
        RemoveContactByEmailResponse response = new RemoveContactByEmailResponse();
        contactService.validateAndDeleteContactByAddress("123 str");
    }

    @Test
    public void testToDisplayNumberOfContacts(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("way");
        addContactRequest.setPhoneNumber("19");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("123 str");
        contactService.addContact(addContactRequest);
        contactService.countNumberOfContacts();
        assertEquals(1 ,contactService.countNumberOfContacts());
    }

    @Test
    public void testToUpdateContact(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("way");
        addContactRequest.setPhoneNumber("19");
        addContactRequest.setEmail("john@do.com");
        contactService.addContact(addContactRequest);
        UpdateContactResponse response = contactService.updateContact("two","09", "way", "mail.com");

    }


















}