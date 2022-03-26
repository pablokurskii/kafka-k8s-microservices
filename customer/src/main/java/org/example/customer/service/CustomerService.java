package org.example.customer.service;

import lombok.AllArgsConstructor;
import org.example.clients.fraud.FraudCheckResponse;
import org.example.clients.fraud.FraudClient;
import org.example.customer.controller.dto.CustomerRegistrationRequest;
import org.example.customer.entity.Customer;
import org.example.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    /*usage of feign client*/
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName((request.lastName()))
                .email(request.email())
                .build();


        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        customerRepository.save(customer);
    }
}
