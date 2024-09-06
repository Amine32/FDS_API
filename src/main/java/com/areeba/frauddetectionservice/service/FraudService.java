package com.areeba.frauddetectionservice.service;

import com.areeba.frauddetectionservice.dto.RequestFraudCheckDto;

public interface FraudService {

    boolean isFraudulentTransaction(RequestFraudCheckDto dto);
}
