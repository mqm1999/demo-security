package com.example.demoPassword.repo;

import com.example.demoPassword.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRoleRepository extends JpaRepository<Long, AccountRole> {
}
