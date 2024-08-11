package com.ContactManagement.web;

import com.ContactManagement.data.model.Contact;
import com.ContactManagement.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/getAllContacts")
@RestController
public class DisplayAllContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/displayContacts")
    public ResponseEntity<Void> DisplayAllContact() {
        DisplayAllContactController display = new DisplayAllContactController();
        display.contactService.findAllContacts();
        ResponseEntity.ok().body(display);
        return ResponseEntity.ok().build();
    }


}
