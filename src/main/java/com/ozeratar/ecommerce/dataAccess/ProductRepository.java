package com.ozeratar.ecommerce.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
