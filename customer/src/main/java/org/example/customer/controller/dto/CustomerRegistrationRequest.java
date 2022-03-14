package org.example.customer.controller.dto;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {}
