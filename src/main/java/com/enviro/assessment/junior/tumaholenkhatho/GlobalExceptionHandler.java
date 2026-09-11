package com.enviro.assessment.junior.tumaholenkhatho;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Centralized exception handling for every controller in the app.
// Instead of ecah contrller method needing its own try/cath, exceptions
// thrown anywhere get caught here and converted into clean HTTP responses.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Catches any InvalidWithdrawalException thrown by our business logic
    // (e.g. exceeds balance, exceeds 90%, retirememnt age rule) and converts
    // it inti a 400 Bad Request with a clear JSON error body.
    @ExceptionHandler(InvalidWithdrawalException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidWithdrawal(InvalidWithdrawalException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Invalid Withdrawal");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
