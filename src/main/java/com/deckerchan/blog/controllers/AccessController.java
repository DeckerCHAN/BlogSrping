package com.deckerchan.blog.controllers;

import com.deckerchan.blog.entities.outbount.Response;
import com.deckerchan.blog.entities.storage.AccessRecord;
import com.deckerchan.blog.repositories.AccessRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class AccessController {

    @Autowired
    private AccessRepository accessRepository;

    @CrossOrigin
    @RequestMapping(value = "api/access", method = RequestMethod.GET)
    public Response writeRecord(HttpServletRequest request, @RequestHeader(value = "User-Agent") String userAgent) {

        try {
            AccessRecord record = new AccessRecord();
            record.setId(UUID.randomUUID());
            record.setAccessDate(new Date());
            record.setAddress(request.getRemoteAddr());
            record.setUserAgent(userAgent);
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
