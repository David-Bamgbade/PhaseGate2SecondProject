package com.ContactManagement.web;

import com.ContactManagement.dto.Request.AddContactRequest;
import com.ContactManagement.dto.Request.FindContactByPhoneNumberRequest;
import com.ContactManagement.dto.Response.AddContactResponse;
import com.ContactManagement.dto.Response.FindContactByPhoneNumberResponse;
import com.ContactManagement.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/contact")
@RestController
public class AddableContact {

    @Autowired
   private ContactService contactService;

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
        public ResponseEntity<?> askContact(@RequestBody FindContactByPhoneNumberRequest request) {
        try {
            FindContactByPhoneNumberResponse responses = new FindContactByPhoneNumberResponse();
                  responses = contactService.findContactByPhoneNumber(request);
            return ResponseEntity.ok(responses);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }





    }



    }

