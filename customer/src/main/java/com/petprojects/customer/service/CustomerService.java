package com.petprojects.customer.service;

import com.petprojects.customer.dto.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest customerRequest);
}
