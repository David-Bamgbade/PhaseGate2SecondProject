package com.ContactManagement.web;

import com.ContactManagement.data.model.Contact;
import com.ContactManagement.data.repositories.ContactRepo;
import com.ContactManagement.dto.Request.AddContactRequest;
import com.ContactManagement.dto.Response.AddContactResponse;
import com.ContactManagement.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/contact")
@RestController
public class AddContactController {

    @Autowired
   private ContactService contactService;

    @PostMapping("/addContact")
    public ResponseEntity<AddContactResponse> addContact(@RequestBody AddContactRequest request) {
            request.setFirstName("david");
            request.setLastName("bamgbade");
            request.setEmail("david@gmail.com");
            request.setPhoneNumber("080");
            AddContactResponse response = contactService.addContact(request);
            return ResponseEntity.ok(response);
        }








        }

