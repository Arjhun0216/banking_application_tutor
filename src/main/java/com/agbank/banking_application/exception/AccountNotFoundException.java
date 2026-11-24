package com.agbank.banking_application.exception;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(){

    }

    public long id ;

    public AccountNotFoundException(Long id){
        super("Account not found with ID: " + id);
    }




}
