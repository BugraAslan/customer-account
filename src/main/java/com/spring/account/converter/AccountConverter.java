package com.spring.account.converter;

import com.spring.account.dto.AccountDto;
import com.spring.account.dto.CustomerAccountDto;
import com.spring.account.model.Account;

import java.util.stream.Collectors;

public class AccountConverter {

    public static AccountDto convert(Account account) {
        return new AccountDto(
                account.getId(),
                account.getBalance(),
                account.getCreatedAt(),
                CustomerConverter.convertToAccountCustomer(account.getCustomer()),
                account.getTransactions().stream()
                        .map(TransactionConverter::convert)
                        .collect(Collectors.toSet())
        );
    }

    public static CustomerAccountDto convertToCustomerAccount(Account account) {
        if (account == null) {
            return null;
        }

        return new CustomerAccountDto(
                account.getId(),
                account.getBalance(),
                account.getCreatedAt(),
                account.getTransactions().stream()
                        .map(TransactionConverter::convert)
                        .collect(Collectors.toSet())
        );
    }
}
