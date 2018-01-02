package com.deckerchan.blog.repositories;

import com.deckerchan.blog.entities.storage.AccessRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccessRepository extends MongoRepository<AccessRecord, UUID> {

}
