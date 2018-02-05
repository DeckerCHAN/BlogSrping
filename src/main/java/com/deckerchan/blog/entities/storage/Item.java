package com.deckerchan.blog.entities.storage;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Item {
    @Id
    public UUID id;
    public String name;
    public String description;
    public double price;
}
