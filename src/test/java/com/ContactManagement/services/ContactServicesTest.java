package com.ContactManagement.services;

import com.ContactManagement.data.repositories.ContactRepo;
import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServicesTest {

    @BeforeEach
    void setUp() {
        contactRepo.deleteAll();
    }

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
        AddContactResponse addContactResponse = contactService.addContact(addContactRequest);
        assertEquals(addContactResponse.getMessage(), "Successfully added contact");
    }

    @Test
    public void testToFindAllContacts(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("eleven");
        addContactRequest.setLastName("kelvin");
        addContactRequest.setPhoneNumber("9090990");
        addContactRequest.setEmail("win@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        DisplayAllContactsResponse response = contactService.findAllContacts();
        assertEquals(response.getMessage(), "All contacts found");
    }

    @Test
    public void testToDeleteContactByPhoneNumber(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("victor");
        addContactRequest.setLastName("dan");
        addContactRequest.setPhoneNumber("56");
        addContactRequest.setEmail("nice@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        RemoveContactByPhoneNumberRequest request = new RemoveContactByPhoneNumberRequest();
        request.setPhoneNumber("56");
        RemoveContactByPhoneNumberResponse response = contactService.validateAndDeleteContactByPhoneNumber(request);
        assertEquals(response.getMessage(), "Contact Deleted");
    }

    @Test
    public void testToFindContactByPhoneNumber(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Ben");
        addContactRequest.setLastName("Ten");
        addContactRequest.setPhoneNumber("90");
        addContactRequest.setEmail("real@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        FindContactByPhoneNumberRequest request = new FindContactByPhoneNumberRequest();
        request.setPhoneNumber("90");
        FindContactByPhoneNumberResponse response = contactService.findContactByPhoneNumber(request);
        assertEquals(response.getMessage(), "Contact found");
    }

    @Test
    public void testToFindContactByName(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("two");
        addContactRequest.setLastName("face");
        addContactRequest.setPhoneNumber("89");
        addContactRequest.setEmail("simple@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        FindContactByNameRequest request = new FindContactByNameRequest();
        FindContactByNameRequest request1 = new FindContactByNameRequest();
        request.setFirstName("two");
        request1.setLastName("face");
        FindContactByNameResponse response = contactService.findContactByName(request, request1);
        assertEquals(response.getMessage(),"Contact found");
    }

    @Test
    public void testToFindDeleteContactByName(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Five");
        addContactRequest.setLastName("Ways");
        addContactRequest.setPhoneNumber("78");
        addContactRequest.setEmail("cool@doe.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        RemoveContactByNameRequest request = new RemoveContactByNameRequest();
        RemoveContactByNameRequest request1 = new RemoveContactByNameRequest();
        request.setFirstName("Five");
        request1.setLastName("Ways");
        RemoveContactByNameResponse response = contactService.validateAndDeleteContactByName(request, request1);
        assertEquals(response.getMessage(),"Contact Deleted");
    }

    @Test
    public void testToDeleteContactByEmail(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("stay");
        addContactRequest.setLastName("put");
        addContactRequest.setPhoneNumber("100");
        addContactRequest.setEmail("stay@do.com");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        RemoveContactByEmailRequest request = new RemoveContactByEmailRequest();
        request.setEmail("stay@do.com");
        RemoveContactByEmailResponse response = contactService.validateAndDeleteContactByEmail(request);
        assertEquals(response.getMessage(),"Contact Deleted");
    }

    @Test
    public void testToFindContactByAddress(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("really");
        addContactRequest.setLastName("big");
        addContactRequest.setPhoneNumber("990");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("my street");
        contactService.addContact(addContactRequest);
        FindContactByAddressRequest request = new FindContactByAddressRequest();
        request.setAddress("my street");
        FindContactByAddressResponse response = contactService.findContactByAddress(request);
        assertEquals(response.getMessage(),"Contact found");
    }

    @Test
    public void testToDeleteContactByAddress(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("what");
        addContactRequest.setLastName("up");
        addContactRequest.setPhoneNumber("199");
        addContactRequest.setEmail("john@do.com");
        addContactRequest.setAddress("123 str");
        contactService.addContact(addContactRequest);
        RemoveContactByAddressRequest request = new RemoveContactByAddressRequest();
        request.setAddress("123 str");
        RemoveContactByAddressResponse response = contactService.validateAndDeleteContactByAddress(request);
        assertEquals(response.getMessage(),"Contact Deleted");
    }

    @Test
    public void testToDisplayNumberOfContacts(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("nice");
        addContactRequest.setLastName("one");
        addContactRequest.setPhoneNumber("192");
        addContactRequest.setEmail("two@do.com");
        addContactRequest.setAddress("123 str");
        contactService.addContact(addContactRequest);
        contactService.countNumberOfContacts();
        assertEquals(1 ,contactService.countNumberOfContacts());
    }

    @Test
    public void testToDeleteAllContact(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("daniel");
        addContactRequest.setLastName("Doe");
        addContactRequest.setPhoneNumber("9090");
        addContactRequest.setEmail("daniel@doe.com");
        addContactRequest.setAddress("the - St");
        contactService.addContact(addContactRequest);
        RemoveAllContactsResponse response = contactService.deleteAllContacts();
        assertEquals("Successfully deleted all contacts", response.getMessage());
    }

    @Test
    public void testToUpdateContact(){
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("another");
        addContactRequest.setLastName("one");
        addContactRequest.setPhoneNumber("300");
        addContactRequest.setEmail("another@do.com");
        addContactRequest.setAddress("main-street");
        contactService.addContact(addContactRequest);
        UpdateContactRequest request1 = new UpdateContactRequest();
        request1.setFirstName("another");
        UpdateContactRequest request2 = new UpdateContactRequest();
        request2.setLastName("one");
        UpdateContactResponse response = contactService.updateContact(request1, request2);
        assertEquals(response.getMessage(),"Updated Successfully");
    }

    @Test
    public void testToFindContactByEmail() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("start");
        addContactRequest.setLastName("now");
        addContactRequest.setEmail("realstuff@do.com");
        addContactRequest.setPhoneNumber("101");
        addContactRequest.setAddress("123 Main St");
        contactService.addContact(addContactRequest);
        FindContactByEmailRequest request = new FindContactByEmailRequest();
        request.setEmail("realstuff@do.com");
        FindContactByEmailResponse response = contactService.findContactByEmail(request);
        assertEquals(response.getMessage(),"Contact found");
    }













}