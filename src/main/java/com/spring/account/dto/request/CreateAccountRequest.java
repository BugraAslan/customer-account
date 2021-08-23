package com.spring.account.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateAccountRequest {

    private String customerId;

    private BigDecimal initialCredit;
}
