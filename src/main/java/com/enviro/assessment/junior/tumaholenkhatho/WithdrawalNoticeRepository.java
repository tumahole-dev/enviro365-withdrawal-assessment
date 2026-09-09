package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.data.jpa.repository.JpaRepository;

/*Extending JpaRepository<WithdrawalNotice, Long> gives us save(), findById(), findAll(),
deleteById(), and more — all implemented automatically by Spring Data JPA at
runtime. Long is the type of Withdrawal's @Id field.
*/
public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {   
}
