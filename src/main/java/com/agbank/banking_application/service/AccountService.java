package com.agbank.banking_application.service;
import com.agbank.banking_application.entity.Account;
import com.agbank.banking_application.exception.AccountNotFoundException;
import com.agbank.banking_application.exception.InsufficientBalanceException;
import com.agbank.banking_application.repository.AccountRepository;
import com.agbank.banking_application.dto.DepositRequest;
import com.agbank.banking_application.dto.WithdrawRequest;

import java.math.BigDecimal;
import java.util.*;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account UpdateAccount(Long id , Account updatedAccount){
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));

        account.setBalance(updatedAccount.getBalance());

        return accountRepository.save(account);

    }
    @Transactional
    public Account DepositService(Long id , DepositRequest depositRequest){
        Account account1 = accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException(id));
        BigDecimal amount = depositRequest.getAmount();
        if(amount.equals(0)){
            throw new RuntimeException("Cannot Deposit negative or Zero Values");
        }
        BigDecimal finalAmount = account1.getBalance().add(amount);
        account1.setBalance(finalAmount);
        return accountRepository.save(account1);
    }

    @Transactional
    public Account WithdrawService(Long id , WithdrawRequest withdrawRequest){
        Account account1 = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
        BigDecimal amount = withdrawRequest.GetAmount();
        if(account1.getBalance().compareTo(amount)<0){
            throw  new InsufficientBalanceException(id);
        }
        BigDecimal finalAmount = account1.getBalance().subtract(amount);
        account1.setBalance(finalAmount);
        return accountRepository.save(account1);

    }
}
