package com.spring.account.dto;

import com.spring.account.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {

    private String id;

    private TransactionType type;

    private BigDecimal amount;

    private LocalDateTime createdAt;
}
