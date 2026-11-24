package com.agbank.banking_application.dto;
import com.agbank.banking_application.entity.Account;

import java.math.BigDecimal;

public class DepositRequest {

    public  BigDecimal amount;

    public DepositRequest(){

    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }
}
