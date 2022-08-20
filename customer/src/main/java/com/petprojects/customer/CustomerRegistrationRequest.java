package com.petprojects.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
