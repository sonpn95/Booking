package com.example.room.repositories;

import com.example.room.models.entities.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {

    List<Optional<AccountRole>> findByAccountId(long accountId);

}
