package com.example.room.services;

import com.example.room.models.entities.AccountRole;
import com.example.room.repositories.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountRoleService {

    @Autowired
    private AccountRoleRepository repository;

    public Optional<AccountRole> findAccountRole(int accountId){
        return repository.findAllByAccountId(accountId);
    }

}

