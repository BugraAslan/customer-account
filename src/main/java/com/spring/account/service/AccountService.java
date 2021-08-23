package com.spring.account.service;

import com.spring.account.converter.AccountConverter;
import com.spring.account.dto.AccountDto;
import com.spring.account.dto.request.CreateAccountRequest;
import com.spring.account.dto.request.UpdateAccountRequest;
import com.spring.account.exception.AccountNotFoundException;
import com.spring.account.model.Account;
import com.spring.account.model.Customer;
import com.spring.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;

    protected Account findById(String id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException("Account not found by id: " + id)
        );
    }

    public AccountDto create(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account();
        account.setBalance(createAccountRequest.getInitialCredit());
        account.setCustomer(customer);

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            account.getTransactions().add(
                    transactionService.initiate(account, account.getBalance())
            );
        }

        return AccountConverter.convert(accountRepository.save(account));
    }

    public AccountDto update(UpdateAccountRequest updateAccountRequest) {
        Account account = findById(updateAccountRequest.getId());
        account.setBalance(updateAccountRequest.getBalance());

        if (updateAccountRequest.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            account.getTransactions().add(
                    transactionService.transfer(account, account.getBalance())
            );
        }

        return AccountConverter.convert(accountRepository.save(account));
    }
}
