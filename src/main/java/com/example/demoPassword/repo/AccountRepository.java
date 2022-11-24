package com.example.demoPassword.repo;

import com.example.demoPassword.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Long, Account> {
    @Query("SELECT a FROM Account a WHERE a.username = :username")
    Optional<Account> findByUserName(String username);
}
