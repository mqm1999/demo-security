package com.example.demoPassword.controller;

import com.example.demoPassword.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    final
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
}
