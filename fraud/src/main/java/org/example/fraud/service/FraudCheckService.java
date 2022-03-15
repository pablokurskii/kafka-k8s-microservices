package org.example.fraud.service;

import lombok.AllArgsConstructor;
import org.example.fraud.entity.FraudCheckHistory;
import org.example.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(OffsetDateTime.now() )
                .build());
        return false;
    }
}
