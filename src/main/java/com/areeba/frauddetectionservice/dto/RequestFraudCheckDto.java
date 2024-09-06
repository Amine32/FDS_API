package com.areeba.frauddetectionservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class RequestFraudCheckDto {
    private UUID cardId;
    private UUID transactionId;
    private BigDecimal amount;
}
