package com.deckerchan.blog.controllers;

import com.deckerchan.blog.entities.inbound.PurchaseRequest;
import com.deckerchan.blog.entities.inbound.ShopDetailRequest;
import com.deckerchan.blog.entities.outbount.Response;
import com.deckerchan.blog.entities.outbount.ShopDetailResponse;
import com.deckerchan.blog.entities.outbount.ShopListResponse;
import com.deckerchan.blog.entities.storage.Item;
import com.deckerchan.blog.entities.storage.Order;
import com.deckerchan.blog.entities.storage.Shop;
import com.deckerchan.blog.entities.storage.User;
import com.deckerchan.blog.repositories.ShopRepository;
import com.deckerchan.blog.repositories.UserRepository;
import com.deckerchan.blog.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@RestController
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private UserRepository userRepository;

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
    @RequestMapping(value = "shop/detail", method = RequestMethod.POST)
    public Response getShopDetails(@RequestBody ShopDetailRequest request) {
        ShopDetailResponse response = new ShopDetailResponse();
        try {
            Shop shop = this.shopRepository.findById(request.getShopId());
            response.setShop(shop);
            response.setSuccessful(shop != null);
        } catch (Exception ex) {
            response.setSuccessful(false);
            response.setErrorMessage(ex.toString());
        } finally {
            return response;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "shop/purchase", method = RequestMethod.POST)
    public Response purchase(@RequestBody PurchaseRequest request) {
        Response response = new Response();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            User user = this.userRepository.findByUsername(auth.getPrincipal().toString());
            Item item = this.shopRepository.findById(request.getShopId()).getItems().stream().filter(x -> x.getId().equals(request.getItemId())).findFirst().orElse(null);

            if (user.getCredits() < item.getPrice()) {
                response.setErrorMessage("Insufficient fund!");
                return response;
            }

            Order order = new Order();
            order.setItem(item);
            order.setTime(new Date());
            order.setId(UUID.randomUUID());

            if (user.getOrders() != null) {
                user.getOrders().add(order);
            } else {
                user.setOrders(Collections.singleton(order));
            }
            user.setCredits(user.getCredits() - item.getPrice());
            this.userRepository.save(user);
            response.setSuccessful(true);
        } catch (Exception ex) {
            response.setSuccessful(false);
            response.setErrorMessage(ex.toString());
            ex.printStackTrace();
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


                shop.setName(RandomUtils.randomText(1, 3, " "));

                shop.setDescription(RandomUtils.randomText(5, 10, " "));

                ArrayList<Item> items = new ArrayList<>();
                for (int j = 0; j < RandomUtils.randomInt(3, 10); j++) {
                    Item item = new Item();
                    item.setName(RandomUtils.randomText(2, 4, " "));

                    item.setDescription(RandomUtils.randomText(5, 10, " "));
                    item.setId(UUID.randomUUID());
                    item.setPrice(RandomUtils.randomInt(5, 10));

                    items.add(item);
                }

                shop.setItems(items);

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
