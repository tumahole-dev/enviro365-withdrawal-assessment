package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.data.jpa.repository.JpaRepository;

/*Extending JpaRepository<Product, Long> gives us save(), findById(), findAll(),
deleteById(), and more — all implemented automatically by Spring Data JPA at
runtime. Long is the type of Product's @Id field.
*/
public interface ProductRepository extends JpaRepository<Product, Long> {
}
