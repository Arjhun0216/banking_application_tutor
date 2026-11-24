package com.agbank.banking_application.controller;

import java.math.BigDecimal;
import java.util.List;

import com.agbank.banking_application.dto.DepositRequest;
import com.agbank.banking_application.dto.WithdrawRequest;
import org.springframework.web.bind.annotation.*;
import com.agbank.banking_application.service.AccountService;
import com.agbank.banking_application.entity.Account;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping
    public Account CreateAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/get/")
    public List<Account> getAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/get/{id}")
    public Account getById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PutMapping("/update/{id}")
    public Account UpdateAccount(@PathVariable Long id , @RequestBody Account account){
        return accountService.UpdateAccount(id,account);
    }

    @PostMapping("/deposit/{id}")
    public Account DepositAmount(@PathVariable Long id , @RequestBody DepositRequest depositRequest){
        return accountService.DepositService(id,depositRequest);

    }

    @PostMapping("/withdraw/{id}")
    public Account WithdrawAmount(@PathVariable Long id , @RequestBody WithdrawRequest withdrawRequest){
        return accountService.WithdrawService(id,withdrawRequest);
    }
}
