package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {
    
    private final InvestorRepository investorRepository;

    public InvestorController(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    // GET /api/investors/{id}/portfolio
    @GetMapping("/{id}/portfolio")
    public PortfolioResponse getPortfolio(@PathVariable Long id) {
        Investor investor = investorRepository.findById(id).orElseThrow(() -> new InvalidWithdrawalException("Investor not found"));

        return new PortfolioResponse(investor);
    }
}
