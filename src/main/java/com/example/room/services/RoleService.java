package com.example.room.services;

import com.example.room.models.entities.AccountRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private AccountRoleService accountRoleService;

    public void findRole(int accountId){
        Optional<AccountRole> accountRolelist= accountRoleService.findAccountRole(accountId);
        for(AccountRole accountRole : accountRolelist){
            List<Integer> roleid = accountRole.getRoleId();
        }

    }
}
