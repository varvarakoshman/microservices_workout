package com.petprojects.fraud.service.impl;

import com.petprojects.fraud.entity.FraudCheckHistory;
import com.petprojects.fraud.repository.FraudCheckHistoryRepository;
import com.petprojects.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckHistoryServiceImpl implements FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFraudster(false)
                .build());
        return false;
    }
}
