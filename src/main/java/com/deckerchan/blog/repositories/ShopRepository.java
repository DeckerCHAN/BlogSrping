package com.deckerchan.blog.repositories;

import com.deckerchan.blog.entities.storage.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ShopRepository extends MongoRepository<Shop, UUID> {

    @Query(value = "{}", fields = "{'name':1,'description':1}")
    List<Shop> findAll();
}
