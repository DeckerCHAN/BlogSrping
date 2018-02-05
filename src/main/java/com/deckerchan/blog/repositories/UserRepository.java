package com.deckerchan.blog.repositories;


import com.deckerchan.blog.entities.storage.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    User findByUsername(String username);
}
