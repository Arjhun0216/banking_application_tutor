package com.agbank.banking_application.exception;

public class InsufficientBalanceException extends  RuntimeException{

    public InsufficientBalanceException(){

    }

    public  InsufficientBalanceException(Long id){
        super("Insufficient Balance in this" + id);
    }
}
