package com.enviro.assessment.junior.tumaholenkhatho;

/* Custom exception for any business rule violation during withdrawal
(e.g. exceeds balance, exceeds 90% limit, retirement withdrawal under age 65).
Extending RuntimeException means callers aren't forced to catch it everywhere
(it's "unchecked") - the global exception handler will catch it centrally instead.
*/

public class InvalidWithdrawalException extends RuntimeException {
    
    public InvalidWithdrawalException(String message) {
        // Passes the message up to RuntimeException, so getMessage() returns it later
        super(message);
    }
}
