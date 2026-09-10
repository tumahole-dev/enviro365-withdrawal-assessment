package com.enviro.assessment.junior.tumaholenkhatho;

import java.math.BigDecimal;

// DTO representing the JSON body the frontend sends when requesting a withdrawal.
// Kept separate from the WithdrawalNotice entity — the client shouldn't need to know
// about internal fields like "status" or "id", it only sends what it's allowed to set.

public class WithdrawalRequest {
    
    private Long productId;
    private BigDecimal amount;

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
