package com.ContactManagement.data.repositories;

import com.ContactManagement.data.model.Contact;

import com.ContactManagement.dto.Request.FindContactByPhoneNumberRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepo extends MongoRepository<Contact, String> {

    @Override
    List<Contact>findAll();




    void deleteByPhoneNumber(String phoneNumber);


    Contact findByPhoneNumber(String request);

    Contact findContactByFirstNameAndLastName(String firstName, String lastName);

    Contact deleteContactByFirstNameAndLastName(String firstName, String lastName);

    Contact findByEmail(String email);

    void deleteByEmail(String email);

    Contact findByAddress(String address);


    void deleteByAddress(String address);

    long count();


}



