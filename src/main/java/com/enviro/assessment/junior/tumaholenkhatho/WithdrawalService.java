package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class WithdrawalService {
    
    private final ProductRepository productRepository;
    private final WithdrawalNoticeRepository withdrawalNoticeRepository;

    // Constructor injection - Spring automatically supplies these repository beans.
    public WithdrawalService(ProductRepository productRepository, WithdrawalNoticeRepository withdrawalNoticeRepository) {
        this.productRepository = productRepository;
        this.withdrawalNoticeRepository = withdrawalNoticeRepository;
    }

    public WithdrawalNotice createWithdrawal(Long productId, BigDecimal amount) {
        // Fetch the product, or fail fast if it doesn't exist.
        Product product = productRepository.findById(productId).orElseThrow(() -> new InvalidWithdrawalException("Product not found"));

        BigDecimal balance = product.getBalance();

        // Rule: retirement withdrawals only allowed if investor's age > 65.
        if ("Retirement".equalsIgnoreCase(product.getType())) {
            Integer age = product.getInvestor().getAge();
            if (age == null || age <= 65) {
                throw new InvalidWithdrawalException(
                    "Retirement wihtdrawals are only allowed for investors over 65"
                );
            }
        }

        // Rule: withdrawal must not exceed 90% of balance.
        BigDecimal maxAllowed = balance.multiply(BigDecimal.valueOf(0.90));
        if (amount.compareTo(maxAllowed) > 0) {
            throw new InvalidWithdrawalException("Withdrawal amount exceeds 90% of balance");
        }

        // All rules passed - deduct the balance and save the updated product.
        product.setBalance(balance.subtract(amount));
        productRepository.save(product);

        // Create and persist the withdrawal notice record.
        WithdrawalNotice notice = new WithdrawalNotice();
        notice.setProduct(product);
        notice.setAmount(amount);
        notice.setDateRequested(LocalDate.now());
        notice.setStatus("APPROVED");

        return withdrawalNoticeRepository.save(notice);
    }
}
