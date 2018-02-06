package com.deckerchan.blog.entities.inbound;

import java.util.UUID;

public class ShopDetailRequest extends Request {
    public UUID getShopId() {
        return shopId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }

    private UUID shopId;

}
