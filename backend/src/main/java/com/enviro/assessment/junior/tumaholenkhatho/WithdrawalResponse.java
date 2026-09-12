package com.enviro.assessment.junior.tumaholenkhatho;

import java.math.BigDecimal;
import java.time.LocalDate;

// DTO for what we send BACK to the client after a withdrawal.
// Flat structure - no nested entity relationships, so no circular reference risk.
public class WithdrawalResponse {
    
    private Long id;
    private Long productId;
    private BigDecimal amount;
    private LocalDate dateRequested;
    private String status;

    public WithdrawalResponse(WithdrawalNotice notice) {
        this.id = notice.getId();
        this.productId = notice.getProduct().getId();
        this.amount = notice.getAmount();
        this.dateRequested = notice.getDateRequested();
        this.status = notice.getStatus();
    }

    public Long getId() { return id; }
    public Long getProductId() { return productId; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDateRequested() { return dateRequested; }
    public String getStatus() { return status; }
}
