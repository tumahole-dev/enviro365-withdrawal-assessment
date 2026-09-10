package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Handles HTTP requests for withdrawals. No business logic here,
// just receives the request, delegates to WithdrawalService, returns the result.
@RestController 
@RequestMapping("/api/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;

    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    // POST /api/withdrawals
    // Request body example: { "products": 1, "amount": 500.00 }
    @PostMapping
    public WithdrawalNotice createWithdrawal(@RequestBody WithdrawalRequest request) {
        return withdrawalService.createWithdrawal(request.getProductId(), request.getAmount());
    }
    
}
