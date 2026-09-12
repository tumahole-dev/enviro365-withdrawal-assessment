package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.data.jpa.repository.JpaRepository;

/*Extending JpaRepository<Investor, Long> gives us save(), 
findById(), findAll(), deleteById(), and more - all implemented automatically
by Spring Data JPA at runtime. Long is the type of Investor's @Id field.
*/ 
public interface InvestorRepository extends JpaRepository<Investor, Long> {  
}
