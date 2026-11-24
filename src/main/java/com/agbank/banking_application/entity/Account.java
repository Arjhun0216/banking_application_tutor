package com.agbank.banking_application.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "accountNumber" ,nullable = false,unique = true  , length = 25)
    private String accountNumber;

    @Column(name ="accountHolderName",nullable = false,length = 70)
    private String accountHolderName;

    @Column(name="balance",nullable=false , precision = 19 , scale = 2)
    private BigDecimal balance;

    public Account(){

    }

    public Account(String accountNumber , String accountholderName , BigDecimal balance){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountholderName;
        this.balance=balance;
    }

    public Long getId(){
        return id;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }
    public BigDecimal getBalance(){
        return balance;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setAccountHolderName(String accountholderName){
        this.accountHolderName=accountholderName;
    }
    public void setBalance(BigDecimal balance){
        this.balance=balance;
    }

}
