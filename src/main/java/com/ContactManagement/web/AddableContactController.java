package com.ContactManagement.web;

import com.ContactManagement.dto.Request.AddContactRequest;
import com.ContactManagement.dto.Request.FindContactByAddressRequest;
import com.ContactManagement.dto.Request.FindContactByPhoneNumberRequest;
import com.ContactManagement.dto.Response.AddContactResponse;
import com.ContactManagement.dto.Response.FindContactByAddressResponse;
import com.ContactManagement.dto.Response.FindContactByPhoneNumberResponse;
import com.ContactManagement.services.ContactService;
import com.ContactManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/contact")
@RestController
public class AddableContactController {

    @Autowired
   private ContactService contactService;

    @Autowired
    private UserService userService;

    @PostMapping("/addContact")
    public ResponseEntity<?> addContact(@RequestBody AddContactRequest request) {
          try {
              AddContactResponse response = contactService.addContact(request);
              return ResponseEntity.ok(response);
          }
          catch (Exception e) {
              return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
          }
        }

    @GetMapping("/askContact")
        public ResponseEntity<?> lookForContactByPhoneNumber(@RequestBody FindContactByPhoneNumberRequest request) {
        try {
            FindContactByPhoneNumberResponse responses = new FindContactByPhoneNumberResponse();
                  responses = contactService.findContactByPhoneNumber(request);
            return ResponseEntity.ok(responses);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/getContact")
    public ResponseEntity<?> lookForContactByAddress(@RequestBody FindContactByAddressRequest request) {
        try{
            contactService.findContactByAddress(request);
            FindContactByAddressResponse response;
            response = contactService.findContactByAddress(request);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }

    }

    @PostMapping("/userAddContact")
    public ResponseEntity<?> userToAddContact(@RequestBody AddContactRequest request) {
        try{
            AddContactResponse response = userService.userAddContact(request);
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }











    }

