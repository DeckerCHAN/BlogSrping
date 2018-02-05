package com.deckerchan.blog.entities.outbount;

import com.deckerchan.blog.entities.storage.Shop;

import java.util.Collection;

public class ShopListResponse extends Response {
    private Collection<Shop> shops;

    public Collection<Shop> getShops() {
        return shops;
    }

    public void setShops(Collection<Shop> shops) {
        this.shops = shops;
    }
}
