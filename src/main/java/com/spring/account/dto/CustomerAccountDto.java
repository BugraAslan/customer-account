package com.spring.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CustomerAccountDto {

    private String id;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private Set<TransactionDto> transactions;
}
