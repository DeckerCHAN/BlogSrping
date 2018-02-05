package com.deckerchan.blog.controllers;


import com.deckerchan.blog.entities.inbound.AccountCredentials;
import com.deckerchan.blog.entities.outbount.Response;
import com.deckerchan.blog.entities.outbount.UserInfoResponse;
import com.deckerchan.blog.entities.storage.User;
import com.deckerchan.blog.repositories.UserRepository;
import com.deckerchan.blog.security.DerekUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private DerekUserDetailsService derekUserDetailsService;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(value = "user/create", method = RequestMethod.POST)
    public Response createUser(@RequestBody AccountCredentials credentials) {
        Response response = new Response();

        try {
            this.derekUserDetailsService.addUser(credentials.getUsername(), credentials.getPassword(), "BASIC");
            response.setSuccessful(true);
        } catch (Exception ex) {
            response.setSuccessful(false);
            response.setErrorMessage(ex.getMessage());
        } finally {
            return response;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "user/info", method = RequestMethod.GET)
    public Response getUserInfo() {
        UserInfoResponse response = new UserInfoResponse();


        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            User user = this.userRepository.findByUsername(auth.getPrincipal().toString());
            String title =   user.getAuthorities().stream().map(GrantedAuthority::getAuthority).reduce( (o, o2) -> o +" and "+ o2).orElse("Unknown").toLowerCase();

            response.setId(user.getId());
            response.setCredits(user.getCredits());
            response.setTitle(title);
            response.setUsername(auth.getPrincipal().toString() );
            response.setSuccessful(true);
        } catch (Exception ex) {
            response.setSuccessful(false);
            response.setErrorMessage(ex.toString());
        } finally {
            return response;
        }
    }

}
