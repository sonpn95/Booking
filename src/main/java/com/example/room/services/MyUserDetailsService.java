package com.example.room.services;

import com.example.room.models.entities.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {
    private final AccountServices accountServices;
    private final AccountRoleService accountRoleService;


    public MyUserDetailsService(AccountServices accountServices, AccountRoleService accountRoleService) {
        this.accountServices = accountServices;
        this.accountRoleService = accountRoleService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountServices.findAccount(email);
        if(account == null){
            throw new UsernameNotFoundException("User" + email +"'not found");
        }
        Set<GrantedAuthority> grantedAuthority =  new HashSet<>();


        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword());
    }
}
