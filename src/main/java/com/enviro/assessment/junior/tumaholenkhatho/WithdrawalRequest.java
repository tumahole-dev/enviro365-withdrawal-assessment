package com.enviro.assessment.junior.tumaholenkhatho;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

// DTO representing the JSON body the frontend sends when requesting a withdrawal.
// Kept separate from the WithdrawalNotice entity — the client shouldn't need to know
// about internal fields like "status" or "id", it only sends what it's allowed to set.

public class WithdrawalRequest {
    
    @NotNull(message = "productId is required")
    private Long productId;

    @NotNull(message = "amount is required")
    @Positive(message = "amount must be greater than zero")
    private BigDecimal amount;

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
