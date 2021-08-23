package com.spring.account.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateAccountRequest {

    private String id;

    private BigDecimal balance;
}
