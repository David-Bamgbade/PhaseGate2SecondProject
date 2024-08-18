package com.ContactManagement.web;

import com.ContactManagement.dto.Request.*;
import com.ContactManagement.dto.Response.*;
import com.ContactManagement.services.ContactService;
import com.ContactManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/contactFind")
@RestController

public class FindableContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    @GetMapping("/findContact")
       public ResponseEntity<?> findContactByNumber(@RequestBody FindContactByPhoneNumberRequest request){
           try {
               FindContactByPhoneNumberResponse response = contactService.findContactByPhoneNumber(request);
               return ResponseEntity.ok(response);
           }
           catch (Exception e){
               return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
           }

        }

    @GetMapping("/findContactByEmail")
    public ResponseEntity<?> findContactsByEmail(@RequestBody FindContactByEmailRequest request1){
        try{
            FindContactByEmailResponse response = contactService.findContactByEmail(request1);
            return ResponseEntity.ok(response);
        }
        catch (Exception c){
            return new ResponseEntity<>(c.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/deleteContactByNumber")
    public ResponseEntity<?> deleteByPhoneNumber(@RequestBody RemoveContactByPhoneNumberRequest request1){
        try {
            RemoveContactByPhoneNumberResponse response = contactService.validateAndDeleteContactByPhoneNumber(request1);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/deleteByAddress")
    public ResponseEntity<?> deleteByAddress(@RequestBody RemoveContactByAddressRequest request1){
        try{
            RemoveContactByAddressResponse response = contactService.validateAndDeleteContactByAddress(request1);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/deleteByEmail")
    public ResponseEntity<?> deleteByContacts(@RequestBody RemoveContactByEmailRequest request1){
        try {
            RemoveContactByEmailResponse response = contactService.validateAndDeleteContactByEmail(request1);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/findContactByName")
    public ResponseEntity<?> findTheContactByName(@RequestBody FindContactByNameRequest request1, FindContactByNameRequest request2){
        try {
            FindContactByNameResponse response = contactService.findContactByName(request1, request2);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/deleteContactByName")
    public ResponseEntity<?> deleteTheContactByName(@RequestBody RemoveContactByNameRequest request1, RemoveContactByNameRequest request2){
        try {
            RemoveContactByNameResponse response = contactService.validateAndDeleteContactByName(request1, request2);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/displayAlContacts")
    public ResponseEntity<?> displayAlContacts(){
        try{
            DisplayAllContactsResponse response = contactService.findAllContacts();
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping
    public ResponseEntity<?> userDeleteByPhoneNumber(@RequestBody RemoveContactByPhoneNumberRequest request){
        try{
            RemoveContactByPhoneNumberResponse response = userService.deleteContactByPhoneNumber(request);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }










    }












