package com.areeba.frauddetectionservice.feign;

import com.areeba.frauddetectionservice.dto.RequestTransactionCountDto;
import com.areeba.frauddetectionservice.dto.ResponseTransactionCountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transaction-service", url = "http://localhost:8080/api/transactions")
public interface TransactionClient {

    @PostMapping("/getTransactionCount")
    ResponseTransactionCountDto getTransactionCountByCardIdAndTransactionDateBetween(
            @RequestBody RequestTransactionCountDto dto);
}
