package com.spring.account.controller;

import com.spring.account.dto.CustomerDto;
import com.spring.account.dto.request.CreateCustomerRequest;
import com.spring.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.ok(customerService.create(createCustomerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
