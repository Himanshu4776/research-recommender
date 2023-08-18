package com.example.researchrecommender.repository;

import com.example.researchrecommender.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{id: ?0}")
    User getByUserId(String id);

    @Query("{$and :[{email: ?0},{password: ?1}] }")
//    @Query("{email: ?0, password: ?1}")
    User getByEmailAndPassword(String email, String password);
//    @Query("{$or :[{author: ?0},{name: ?1}]}")
//@Query("{author: ?0, cost: ?1}")
    @Query("{email: ?0}")
    User getByEmail(String email);
}
