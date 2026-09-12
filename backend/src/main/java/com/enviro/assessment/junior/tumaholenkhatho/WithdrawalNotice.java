package com.enviro.assessment.junior.tumaholenkhatho;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class WithdrawalNotice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which product/holding this withdrawal is being taken from.
    // Same pattern as Product -> Investor: this is the OWNING side,
    // so it holds the foreign key column in the database.
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    // The amount the investor is requesting to withdraw.
    // BigDecimal again, for exact money arithmetic (see Product.balance).
    private BigDecimal amount;

    // The date the the withdrawal was requested - needed for the history table
    // and for CSV export filtering (e.g. "withdrawals in the last month").
    private LocalDate dateRequested;

    // Outcome of the business rule checks, e.g. "APPROVED" or "REJECTED".
    // Kept as a plain STring here rather than a Java enum to keep things simple
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getDateRequested() { return dateRequested; }
    public void setDateRequested(LocalDate dateRequested) { this.dateRequested = dateRequested; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
} 
