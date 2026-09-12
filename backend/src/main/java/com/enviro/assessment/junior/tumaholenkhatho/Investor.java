package com.enviro.assessment.junior.tumaholenkhatho;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// @Entity tells Hibernate this class maps to a database table (named "investor" by default).
@Entity
public class Investor {
    
    // Primary key column.
    @Id
    // Database auto-generates this value (auto-increment) - we never set it manually.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    // Needed for the "retirement wihtdrawal only if age > 65" business rule.
    private Integer age;

    /*"One investor has many products." mappedBy = "investor" points to the field
    on the Product side that actually owns the foreign key - Investor is the
    non-owning ("inverse") side of this relationship.
    cascade = ALL means saving/deleting an Investor also saves/deletes their Products.
    */
    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    private List<Product> products;

    // Getters and Setters - Hibernate needs these to read/write field values.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}