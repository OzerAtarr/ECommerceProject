package com.ozeratar.ecommerce.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.ecommerce.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
