package com.deckerchan.blog.security;

import com.deckerchan.blog.entities.storage.User;
import com.deckerchan.blog.repositories.UserRepository;
import com.deckerchan.blog.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;

@Component
public class DerekUserDetailsService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return user;
        }
    }

    public void addUser(String username, String password, String role) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(username);
        user.setPassword(CodeUtils.getHash(password));
        user.setCredits(15D);
        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority(role)));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        this.userRepository.insert(user);
    }
}
