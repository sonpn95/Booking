package com.example.room.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email){
        return new User("foo","foo",new ArrayList<>());
    }
}
