package com.spring.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {

    private String id;

    private String name;

    private String surname;

    private Set<CustomerAccountDto> accounts;
}
