package com.example.demoPassword.service.impl;

import com.example.demoPassword.entity.Account;
import com.example.demoPassword.entity.Role;
import com.example.demoPassword.repo.AccountRepository;
import com.example.demoPassword.repo.RoleRepository;
import com.example.demoPassword.utils.CustomUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    final
    AccountRepository accountRepository;

    final
    RoleRepository roleRepository;

    public UserDetailServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUserName(username);
        if (account.isEmpty()) {
            return null;
        }
        List<Role> roles = roleRepository.findById(account.get().getId());
        List<String> roleList = new ArrayList<>();
        for (Role role : roles) {
            roleList.add(role.getRoleName().name());
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (!roleList.isEmpty()) {
            for (String role : roleList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                grantedAuthorityList.add(grantedAuthority);
            }
        }
        return new CustomUserDetails(account.get().getUsername(), account.get().getPassword(), grantedAuthorityList);
    }
}
