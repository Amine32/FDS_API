package com.areeba.frauddetectionservice.controller;

import com.areeba.frauddetectionservice.dto.RequestFraudCheckDto;
import com.areeba.frauddetectionservice.service.FraudImpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-check")
@RequiredArgsConstructor
public class FraudController {

    private final FraudImpService fraudService;

    @PostMapping
    public Boolean checkFraud(@RequestBody RequestFraudCheckDto dto) {
        return fraudService.isFraudulentTransaction(dto);
    }
}
