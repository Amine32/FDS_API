package com.areeba.frauddetectionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class RequestTransactionCountDto {
    private UUID cardId;
    private Timestamp startDate;
    private Timestamp endDate;
}
