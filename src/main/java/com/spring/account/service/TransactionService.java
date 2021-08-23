package com.spring.account.service;

import com.spring.account.model.Account;
import com.spring.account.model.Transaction;
import com.spring.account.model.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    protected Transaction initiate(Account account, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);

        return transaction;
    }

    protected Transaction transfer(Account account, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setType(TransactionType.TRANSFER);

        return transaction;
    }
}
