package com.ContactManagement.data.repositories;

import com.ContactManagement.data.model.Contact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContactRepo extends MongoRepository<Contact, String> {

    @Override
    List<Contact> findAll();

    List<Contact> findBy(String address);

//    List<Contact> findByPhoneNumber(String phoneNumber);

    List<Contact> findContactByPhoneNumber(String phoneNumber);

    List<Contact> deleteContactByPhoneNumber(String phoneNumber);

    void deleteByPhoneNumber(String phoneNumber);


    List<Contact> findByPhoneNumber(String phoneNumber);

    List<Contact> findContactByFirstNameAndLastName(String firstName, String lastName);

    List<Contact> deleteContactByFirstNameAndLastName(String firstName, String lastName);

    List<Contact> findByEmail(String email);

    void deleteByEmail(String email);

    List<Contact> findByAddress(String address);


    void deleteByAddress(String address);

    long count();
}



