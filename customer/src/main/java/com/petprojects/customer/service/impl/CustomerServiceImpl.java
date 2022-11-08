package com.petprojects.customer.service.impl;

import com.petprojects.clients.fraud.FraudCheckResponse;
import com.petprojects.clients.fraud.FraudClient;
import com.petprojects.clients.notification.NotificationClient;
import com.petprojects.clients.notification.NotificationRequest;
import com.petprojects.customer.dto.CustomerRegistrationRequest;
import com.petprojects.customer.entity.Customer;
import com.petprojects.customer.repository.CustomerRepository;
import com.petprojects.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // TODO: check if email is valid
        // TODO: check if email not taken
        // TODO: store customer in db
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        notificationClient.sendNotification(getCustomerNotification(customer));
    }

    private NotificationRequest getCustomerNotification(Customer customer) {
        String message = String.format("Hello %s, you were successfully registered", customer.getFirstName());
        return new NotificationRequest(customer.getId(), customer.getEmail(), message);
    }
}
