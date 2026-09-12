package com.enviro.assessment.junior.tumaholenkhatho;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

// Centralized exception handling for every controller in the app.
// Instead of each controller method needing its own try/catch, exceptions
// thrown anywhere get caught here and converted into clean HTTP responses.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Catches any InvalidWithdrawalException thrown by our business logic
    // (e.g. exceeds balance, exceeds 90%, retirement age rule) and converts
    // it into a 400 Bad Request with a clear JSON error body.
    @ExceptionHandler(InvalidWithdrawalException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidWithdrawal(InvalidWithdrawalException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Invalid Withdrawal");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Catches validation failures from @Valid on request DTOs (e.g. negative
    // amount, missing productId) and converts them into a 400 with all
    // field-level error messages combined into one readable string.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Validation Failed");

        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(java.util.stream.Collectors.joining(", "));
        body.put("message", message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}