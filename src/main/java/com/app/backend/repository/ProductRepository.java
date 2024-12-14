package com.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
