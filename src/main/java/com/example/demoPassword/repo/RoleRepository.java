package com.example.demoPassword.repo;

import com.example.demoPassword.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Long, Role> {
    @Query("SELECT r FROM Role r " +
            "JOIN AccountRole ac ON r.id = ac.roleId " +
            "JOIN Account a ON ac.accountId = a.id WHERE a.id = :accountId")
    List<Role> findById(Long accountId);
}
