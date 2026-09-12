package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;
    private final WithdrawalNoticeRepository withdrawalNoticeRepository;

    public WithdrawalController(WithdrawalService withdrawalService,
                                 WithdrawalNoticeRepository withdrawalNoticeRepository) {
        this.withdrawalService = withdrawalService;
        this.withdrawalNoticeRepository = withdrawalNoticeRepository;
    }

    // POST /api/withdrawals
    // Request body example: { "productId": 1, "amount": 500.00 }
    @PostMapping
    public WithdrawalResponse createWithdrawal(@Valid @RequestBody WithdrawalRequest request) {
        WithdrawalNotice notice = withdrawalService.createWithdrawal(request.getProductId(), request.getAmount());
        return new WithdrawalResponse(notice);
    }

    // GET /api/withdrawals
    // Returns all withdrawal notices as flat DTOs, for the frontend history table.
    @GetMapping
    public List<WithdrawalResponse> getAllWithdrawals() {
        return withdrawalNoticeRepository.findAll().stream()
                .map(WithdrawalResponse::new)
                .collect(Collectors.toList());
    }
}