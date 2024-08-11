package com.ContactManagement.web;

import com.ContactManagement.data.repositories.ContactRepo;
import com.ContactManagement.dto.Request.FindContactByPhoneNumberRequest;
import com.ContactManagement.dto.Response.FindContactByPhoneNumberResponse;
import com.ContactManagement.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/getContact")
@RestController
public class GetContactByPhoneNumberRequest {
    @Autowired
    private ContactService contactService;


    @GetMapping("/askContact")
    public ResponseEntity<List<FindContactByPhoneNumberResponse>> askContact(@RequestBody String phoneNumber) {
        FindContactByPhoneNumberRequest request = new FindContactByPhoneNumberRequest();
        request.setPhoneNumber(phoneNumber);
        List<FindContactByPhoneNumberResponse> responses = contactService.findContactByPhoneNumber(request.getPhoneNumber());
        return ResponseEntity.ok(responses);
    }



}
