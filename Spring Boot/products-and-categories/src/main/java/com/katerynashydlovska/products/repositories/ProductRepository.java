package com.katerynashydlovska.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.katerynashydlovska.products.models.Categories;
import com.katerynashydlovska.products.models.Products;



@Repository
public interface ProductRepository extends CrudRepository<Products, Long>{
	
	List<Products> findByCategoriesNotContaining(Categories c);

}
