package com.spring.account.converter;

import com.spring.account.dto.AccountCustomerDto;
import com.spring.account.dto.CustomerDto;
import com.spring.account.model.Customer;

import java.util.stream.Collectors;

public class CustomerConverter {

    public static CustomerDto convert(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts().stream()
                        .map(AccountConverter::convertToCustomerAccount)
                        .collect(Collectors.toSet())
        );
    }

    public static AccountCustomerDto convertToAccountCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new AccountCustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname()
        );
    }
}
