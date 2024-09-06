package com.areeba.frauddetectionservice.controller;

import com.areeba.frauddetectionservice.dto.RequestFraudCheckDto;
import com.areeba.frauddetectionservice.dto.ResponseErrorDto;
import com.areeba.frauddetectionservice.service.FraudImpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-check")
@RequiredArgsConstructor
@Tag(name = "Fraud API", description = "Operations related to FraudChecks")
public class FraudController {

    private final FraudImpService fraudService;

    @Operation(summary = "Check Potential Fraud", description = "Return true if fraudulent")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully checked for fraud"),
            @ApiResponse(responseCode = "400", description = "Something went wrong",
                    content = @Content(schema = @Schema(implementation = ResponseErrorDto.class)))
    })
    @PostMapping
    public Boolean checkFraud(@RequestBody RequestFraudCheckDto dto) {
        return fraudService.isFraudulentTransaction(dto);
    }
}
