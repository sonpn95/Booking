package com.example.room.services;

import com.example.room.models.entities.AccountRole;
import com.example.room.repositories.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountRoleService {
    private final AccountRoleRepository repository;
    public AccountRoleService(AccountRoleRepository repository){
        this.repository = repository;
    }

    public List<Optional<AccountRole>> findAccountRole(long accountId){
        return repository.findByAccountId(accountId);
    }

}

