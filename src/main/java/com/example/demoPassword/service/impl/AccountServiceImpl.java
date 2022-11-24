package com.example.demoPassword.service.impl;

import com.example.demoPassword.repo.AccountRepository;
import com.example.demoPassword.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    final
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
