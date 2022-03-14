package org.example.customer.service;

import org.example.customer.controller.dto.CustomerRegistrationRequest;
import org.example.customer.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName((request.lastName()))
                .email(request.email())
                .build();
//        TODO check email valid
//        TODO check email not taken
//        TODO store customer in DB
    }
}
