package com.example.room.services;

import com.example.room.models.entities.Account;
import com.example.room.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServices {
    private final AccountRepository repository;
    private Optional<Account> account;

    public AccountServices(AccountRepository repository) {
        this.repository = repository;
    }

    public Account findAccount(String email){
        account = repository.findByEmail(email);
        if(!account.isPresent()){
            return null;
        }
        return account.get();

    }


}
