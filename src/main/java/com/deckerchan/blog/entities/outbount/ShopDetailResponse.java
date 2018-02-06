package com.deckerchan.blog.entities.outbount;

import com.deckerchan.blog.entities.storage.Shop;

public class ShopDetailResponse extends Response {
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
