package com.spring.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountCustomerDto {

    private String id;

    private String name;

    private String surname;
}
