package com.areeba.frauddetectionservice.model;

import com.areeba.frauddetectionservice.common.Enums;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "fraud_check", schema = "fraud_detection_service")
@RequiredArgsConstructor
public class FraudCheck {

    public FraudCheck(UUID transactionId, Enums.Reason reason) {
        this.transactionId = transactionId;
        this.reason = reason;
    }

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull(message = "Transaction ID is mandatory")
    private UUID transactionId;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Reason for fraud check is mandatory")
    private Enums.Reason reason;
}
