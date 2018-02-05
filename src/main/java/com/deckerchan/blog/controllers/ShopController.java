package com.deckerchan.blog.controllers;

import com.deckerchan.blog.entities.outbount.ShopListResponse;
import com.deckerchan.blog.entities.storage.Shop;
import com.deckerchan.blog.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @CrossOrigin
    @RequestMapping(value = "shop/list", method = RequestMethod.GET)
    public ShopListResponse getShopList() {
        ShopListResponse response = new ShopListResponse();

        try {
            response.setShops(this.shopRepository.findAll());
            response.setSuccessful(true);
//            for (int i = 0; i <= 20; i++) {
//                Shop shop = new Shop();
//                shop.setId(UUID.randomUUID());
//                shop.setName("Shop Name " + i);
//                shop.setDescription("I am description for shop " + i);
//                this.shopRepository.insert(shop);
//            }

        } catch (Exception ex) {

            response.setSuccessful(false);
            response.setErrorMessage(ex.toString());

        } finally {
            return response;
        }

    }
}
