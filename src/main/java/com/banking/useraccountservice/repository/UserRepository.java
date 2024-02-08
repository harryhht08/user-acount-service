package com.banking.useraccountservice.repository;

import com.banking.useraccountservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    // You can define other query methods as needed
}
