package com.enviro.assessment.junior.tumaholenkhatho;

import java.util.List;
import java.util.stream.Collectors;

// Flat representation of an investor's full portfolio: their details plus
// a list of ProductSummary (not raw Product entities) to avoid circular references.
public class PortfolioResponse {
    
    private Long investorId;
    private String name;
    private Integer age;
    private List<ProductSummary> products;

    public PortfolioResponse(Investor investor) {
        this.investorId = investor.getId();
        this.name = investor.getName();
        this.age = investor.getAge();
        this.products = investor.getProducts().stream().map(ProductSummary::new).collect(Collectors.toList());
    }

    public Long getInvestorId() { return investorId; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public List<ProductSummary> getProducts() { return products; }
}
