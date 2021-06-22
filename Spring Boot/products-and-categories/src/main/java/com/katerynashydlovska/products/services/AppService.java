package com.katerynashydlovska.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katerynashydlovska.products.models.Categories;
import com.katerynashydlovska.products.models.Products;
import com.katerynashydlovska.products.repositories.CategoryRepository;
import com.katerynashydlovska.products.repositories.ProductRepository;

@Service
public class AppService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
	public AppService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
		this.productRepo = productRepo;
	}
	
	public Products createProduct(Products p) {
		return this.productRepo.save(p);
	}
	
	public List<Products> getAllProd(){
		return (List<Products>)this.productRepo.findAll();
		}
	
	public Categories createCategory(Categories c) {
		return this.categoryRepo.save(c);
	}
	
	public List<Categories> getAllCateg(){
		return (List<Categories>)this.categoryRepo.findAll();
		}
	
	public Categories getOneCategory(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
	}
	
	public Products getOneProduct(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	
	
		public void joinProductToCategory(Long product_id, Long category_id) {
			Products p = this.productRepo.findById(product_id).orElse(null);
			Categories c = this.categoryRepo.findById(category_id).orElse(null);

				
			List<Products> product = c.getProducts();
			product.add(p);
			c.setProducts(product);
			
		
			this.categoryRepo.save(c);
		}
		
		
		public void joinCategoryToProduct(Long category_id, Long product_id) {
			Products p = this.productRepo.findById(product_id).orElse(null);
			Categories c = this.categoryRepo.findById(category_id).orElse(null);
			
			p.getCategories().add(c);
		
			this.productRepo.save(p);
		}
		
		public List<Products> findNonRelatedProducs(Categories c){
			return this.productRepo.findByCategoriesNotContaining(c);
			
		}
		
		public List<Categories> findNonRelatedCategories(Products p){
			return this.categoryRepo.findByProductsNotContaining(p);
			
		}

}
