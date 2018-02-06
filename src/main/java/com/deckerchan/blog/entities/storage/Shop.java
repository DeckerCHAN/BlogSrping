package com.deckerchan.blog.entities.storage;

import org.springframework.data.annotation.Id;

import java.util.Collection;
import java.util.UUID;

public class Shop {
    @Id
    private UUID id;
    private String name;
    private String description;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    private Collection<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
