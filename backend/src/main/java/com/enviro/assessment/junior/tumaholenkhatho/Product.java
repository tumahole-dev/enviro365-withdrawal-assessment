package com.enviro.assessment.junior.tumaholenkhatho;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity 
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* e.g. "Retirement" or "Savings" - determines which business rules apply
    (only "Retirement" type products are subject to the age > 65 rule).
    */
    private String type;

    /* BigDecimal, not double/float - money needs exact decimal arithmetic, 
    since binary floating-point types introduce rounding errors
    (e.g. 0.1 + 0.2 != 3 exactly in a double).
    */
    private BigDecimal balance;

    /* "Many products belong to one investor." This is the OWNING side of the
    relationship - it holds the actual foreign key column in the database.
    */
    @ManyToOne
    @JoinColumn(name = "investor_id") //names the foreign key column explicitly
    private Investor investor;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public Investor getInvestor() { return investor; }
    public void setInvestor(Investor investor) { this.investor = investor; }
}
