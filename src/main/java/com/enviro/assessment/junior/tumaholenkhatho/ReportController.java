package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    
    private final WithdrawalNoticeRepository withdrawalNoticeRepository;
    
    public ReportController(WithdrawalNoticeRepository withdrawalNoticeRepository) {
        this.withdrawalNoticeRepository = withdrawalNoticeRepository;
    }

    // GET /api/reports/withdrawals/csv?start=2026-01-01&end=2026-12-31
    @GetMapping("/withdrawals/csv")
    public ResponseEntity<String> exportWithdrawalsCsv(
        @RequestParam LocalDate start, @RequestParam LocalDate end) {
        
    List<WithdrawalNotice> notices = withdrawalNoticeRepository.findByDateRequestedBetween(start, end);
    
    // Build the CSV content manually, row by row.
    StringBuilder csv = new StringBuilder();
    csv.append("Investor Name, Product Type, Amount, Date Requested, Status\n");

    for (WithdrawalNotice notice : notices) {
        csv.append(notice.getProduct().getInvestor().getName()).append(",");
        csv.append(notice.getProduct().getType()).append(",");
        csv.append(notice.getAmount()).append(",");
        csv.append(notice.getDateRequested()).append(",");
        csv.append(notice.getStatus()).append("\n");
    }
    
    // Set headers so the browser/client treats this as a downloadable CSV file,
    // not plain text to display inline.
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=withdrawals.csv");
    
    return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("text/csv")).body(csv.toString());

    }
}
