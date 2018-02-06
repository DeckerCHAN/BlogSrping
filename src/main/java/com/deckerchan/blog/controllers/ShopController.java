package com.deckerchan.blog.controllers;

import com.deckerchan.blog.entities.outbount.Response;
import com.deckerchan.blog.entities.outbount.ShopListResponse;
import com.deckerchan.blog.entities.storage.Shop;
import com.deckerchan.blog.repositories.ShopRepository;
import com.deckerchan.blog.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

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

        } catch (Exception ex) {

            response.setSuccessful(false);
            response.setErrorMessage(ex.toString());

        } finally {
            return response;
        }

    }

    @CrossOrigin
    @RequestMapping(value = "shop/fill", method = RequestMethod.GET)
    public Response fillShopList() {
        Response response = new Response();


        try {

            for (int i = 0; i <= 20; i++) {
                Shop shop = new Shop();
                shop.setId(UUID.randomUUID());


                shop.setName(RandomUtils.randomName(1,3," "));

                shop.setDescription(RandomUtils.randomName(5,10," "));
                this.shopRepository.insert(shop);
            }
            response.setSuccessful(true);

        } catch (Exception ex) {

            response.setSuccessful(false);
            response.setErrorMessage(ex.toString());

        } finally {
            return response;
        }

    }
}
