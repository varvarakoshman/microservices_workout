package com.petprojects.fraud.service;

public interface FraudCheckHistoryService {

    boolean isFraudulentCustomer(Integer customerId);
}