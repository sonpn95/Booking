package com.example.room.services;

import com.example.room.models.entities.Account;
import com.example.room.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {
    @Autowired
    AccountRepository repository;

    public Account findAccount(String email){
        return repository.findByEmail(email);
    }


}
