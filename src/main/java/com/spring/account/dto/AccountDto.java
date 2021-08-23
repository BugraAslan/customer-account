package com.spring.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto {

    private String id;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private AccountCustomerDto customer;

    private Set<TransactionDto> transactions;
}
