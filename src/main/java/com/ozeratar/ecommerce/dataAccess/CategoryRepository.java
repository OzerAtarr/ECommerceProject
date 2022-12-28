package com.ozeratar.ecommerce.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozeratar.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
