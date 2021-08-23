package com.spring.account.converter;

import com.spring.account.dto.TransactionDto;
import com.spring.account.model.Transaction;

public class TransactionConverter {

    public static TransactionDto convert(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getCreatedAt()
        );
    }
}
