package com.katerynashydlovska.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.katerynashydlovska.products.models.Categories;
import com.katerynashydlovska.products.models.Products;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, Long>{
	
	List<Categories> findByProductsNotContaining(Products p);

}

