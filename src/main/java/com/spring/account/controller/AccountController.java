package com.spring.account.controller;

import com.spring.account.dto.AccountDto;
import com.spring.account.dto.request.CreateAccountRequest;
import com.spring.account.dto.request.UpdateAccountRequest;
import com.spring.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> create(@RequestBody CreateAccountRequest createAccountRequest) {
        return ResponseEntity.ok(accountService.create(createAccountRequest));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@RequestBody UpdateAccountRequest updateAccountRequest) {
        return ResponseEntity.ok(accountService.update(updateAccountRequest));
    }
}
