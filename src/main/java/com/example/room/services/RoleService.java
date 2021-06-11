package com.example.room.services;

import com.example.room.models.entities.AccountRole;
import com.example.room.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final AccountRoleService accountRoleService;
    private final RoleRepository repository;

    public RoleService(AccountRoleService accountRoleService, RoleRepository repository) {
        this.accountRoleService = accountRoleService;
        this.repository = repository;
    }

    public List<String> findRole(long accountId){

        // lay List roleid tu AccountRole
        List<Optional<AccountRole>> accountRoles = accountRoleService.findAccountRole(accountId);
        List<Long> roleId = new ArrayList<>();
        for(Optional<AccountRole> accountRole : accountRoles){
           roleId.add(accountRole.get().getRoleId());
        }

        // lay List roleName
        List<String> roleName = new ArrayList<>();
        for(Long roleid : roleId){
            roleName.add(repository.findById(roleid).get().getName());
        }

        return  roleName;
    }




}
