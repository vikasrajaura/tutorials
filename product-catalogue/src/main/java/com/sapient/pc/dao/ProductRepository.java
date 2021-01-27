package com.sapient.pc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.pc.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
