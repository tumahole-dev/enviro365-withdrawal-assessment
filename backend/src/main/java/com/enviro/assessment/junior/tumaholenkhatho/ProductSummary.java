package com.enviro.assessment.junior.tumaholenkhatho;

import java.math.BigDecimal;


// Flat representation of a single product, used inside PortfolioResponse.
// No reference back to investor - that's exactly what avoids the circular loop
public class ProductSummary {
    private Long id;
    private String type;
    private BigDecimal balance;

    public ProductSummary(Product product) {
        this.id = product.getId();
        this.type = product.getType();
        this.balance = product.getBalance();
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public BigDecimal getBalance() { return balance; }
}
