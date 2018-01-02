package com.deckerchan.blog.controllers;

import com.deckerchan.blog.entities.inbound.AccessRequest;
import com.deckerchan.blog.entities.outbount.Response;
import com.deckerchan.blog.entities.storage.AccessRecord;
import com.deckerchan.blog.repositories.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class AccessController {

    @Autowired
    private AccessRepository accessRepository;

    @CrossOrigin
    @RequestMapping(value = "api/access", method = RequestMethod.POST)
    public Response writeRecord(@RequestBody AccessRequest request) {

        try {
            AccessRecord record = new AccessRecord();
            record.setId(UUID.randomUUID());
            record.setAccessDate(new Date());
            record.setBrowserName(request.getBrowserName());
            record.setDevice(request.getDevice());
            record.setOsName(request.getOsName());
            this.accessRepository.insert(record);
            Response response = new Response();
            response.setSuccessful(true);
            return response;
        } catch (Exception ex) {
            Response response = new Response();
            response.setSuccessful(false);
            response.setErrorMessage(ex.getMessage());
            return response;
        }

    }
}
