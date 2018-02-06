package com.deckerchan.blog.entities.inbound;

import java.util.UUID;

public class PurchaseRequest extends Request {
    private UUID itemId;

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public UUID getShopId() {
        return shopId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }

    private UUID shopId;

}
