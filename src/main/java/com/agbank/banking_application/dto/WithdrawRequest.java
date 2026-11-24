package com.agbank.banking_application.dto;
import com.agbank.banking_application.entity.Account;

import java.math.BigDecimal;
public class WithdrawRequest {

    public BigDecimal amount ;

    public WithdrawRequest(){
    }

    public  BigDecimal GetAmount(){
        return amount;
    }

    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }
}
