package com.deckerchan.blog.controllers;

import com.deckerchan.blog.entities.inbound.RecordRequest;
import com.deckerchan.blog.entities.outbount.Response;
import com.deckerchan.blog.entities.storage.AccessRecord;
import com.deckerchan.blog.repositories.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class AccessController {

    @Autowired
    private AccessRepository accessRepository;

    @CrossOrigin
    @RequestMapping(value = "access", method = RequestMethod.POST)
    public Response writeRecord(@RequestHeader(value = "X-Real-IP") String realIp, @RequestBody RecordRequest request) {

        try {
            AccessRecord record = new AccessRecord();
            record.setId(UUID.randomUUID());
            record.setAccessDate(new Date());
            record.setAddress(realIp);
            record.setAppCodeName(request.getAppCodeName());
            record.setPlatform(request.getPlatform());
            record.setVendor(request.getVendor());
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
