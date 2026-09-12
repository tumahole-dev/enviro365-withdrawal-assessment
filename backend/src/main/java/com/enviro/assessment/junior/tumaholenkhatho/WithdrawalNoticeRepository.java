package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

/*Extending JpaRepository<WithdrawalNotice, Long> gives us save(), findById(), findAll(),
deleteById(), and more — all implemented automatically by Spring Data JPA at
runtime. Long is the type of Withdrawal's @Id field.
*/
public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {   
    /*Spring Data JPA reads this method NAME and automatically generates
    the correct SQL query from it - no implementation needed, no SQL written by us.
    "findBy" + "DateRequestedBetween" -> WHERE date_requested BETWEEN ? AND ?
    */
    List<WithdrawalNotice> findByDateRequestedBetween(LocalDate start, LocalDate end);
}
