package com.spring.account.service;

import com.spring.account.converter.CustomerConverter;
import com.spring.account.dto.CustomerDto;
import com.spring.account.dto.request.CreateCustomerRequest;
import com.spring.account.exception.CustomerNotFoundException;
import com.spring.account.model.Customer;
import com.spring.account.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found by id: " + id)
        );
    }

    public CustomerDto getCustomerById(String id) {
        return CustomerConverter.convert(findCustomerById(id));
    }

    public CustomerDto create(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setSurname(createCustomerRequest.getSurname());

        return CustomerConverter.convert(customerRepository.save(customer));
    }
}
