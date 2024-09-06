package com.areeba.frauddetectionservice.service;

import com.areeba.frauddetectionservice.common.Enums;
import com.areeba.frauddetectionservice.dto.RequestFraudCheckDto;
import com.areeba.frauddetectionservice.dto.RequestTransactionCountDto;
import com.areeba.frauddetectionservice.feign.TransactionClient;
import com.areeba.frauddetectionservice.model.FraudCheck;
import com.areeba.frauddetectionservice.repository.FraudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FraudImpService implements FraudService {

    private final FraudRepository fraudRepository;
    private final TransactionClient transactionClient;

    @Value("${fraud.detection.limit}")
    private BigDecimal amountLimit;

    @Value("${fraud.detection.interval}")
    private Duration timeInterval;

    @Override
    public boolean isFraudulentTransaction(RequestFraudCheckDto dto) {
        //Check if transaction amount exceeds $10,000
        if (dto.getAmount().compareTo(amountLimit) > 0) {
            saveFraudCheck(dto.getTransactionId(), Enums.Reason.AMOUNT_LIMIT_EXCEEDED);
            return true;
        }

        //Check if transactions exceed 8 in an hour for specific card
        Timestamp intervalStartTime = new Timestamp(System.currentTimeMillis() - timeInterval.toMillis());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        int transactionCount = transactionClient.getTransactionCountByCardIdAndTransactionDateBetween(
                new RequestTransactionCountDto(dto.getCardId(), intervalStartTime, currentTime)).getTransactionCount();

        if (transactionCount > 8) {
            saveFraudCheck(dto.getTransactionId(), Enums.Reason.EXCESSIVE_TRANSACTIONS);
            return true;
        }

        return false;
    }

    private void saveFraudCheck(UUID transactionId, Enums.Reason reason) {
        FraudCheck fraudCheck = new FraudCheck(transactionId, reason);
        fraudRepository.save(fraudCheck);
    }
}
