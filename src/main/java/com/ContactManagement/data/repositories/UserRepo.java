package com.ContactManagement.data.repositories;

import com.ContactManagement.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends MongoRepository<User, String> {
    User findByUserId(String userId);

    User findByUserName(String username);

    User findByEmail(String email);

    User findByUserNameAndPassword(String username, String password);

    User findByEmailAndPassword(String userName, String password);

    User findByPassword(String password);

    User findByPhoneNumber(String phoneNumber);









}
