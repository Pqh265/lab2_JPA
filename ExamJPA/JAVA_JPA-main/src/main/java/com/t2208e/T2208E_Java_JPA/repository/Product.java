package com.t2208e.T2208E_Java_JPA.repository;

import com.t2208e.T2208E_Java_JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
