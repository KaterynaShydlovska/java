package com.katerynashydlovska.products;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.katerynashydlovska.products.models.Categories;
import com.katerynashydlovska.products.models.Products;
import com.katerynashydlovska.products.services.AppService;

@Controller
public class AppController {
	
	private final AppService appService;
	
	public AppController(AppService appService) {
		this.appService = appService;
	}
	
	@GetMapping("/new/product")
	public String newProduct(@ModelAttribute("product") Products products, Model model) {
		return "NewProduct.jsp";
	}
	@PostMapping("/product/create")
	public String create(@Valid @ModelAttribute("product") Products products, BindingResult result) {
		if(result.hasErrors()) {
			return "NewProduct.jsp";
		}else {
			this.appService.createProduct(products);
			return "redirect:/new/product";
		}
		
	}
	
	@GetMapping("/new/category")
	public String newCategory(@ModelAttribute("category") Categories categories, Model model) {
		return "NewCategory.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Categories categories, BindingResult result) {
		if(result.hasErrors()) {
			return "NewCategory.jsp";
		}else {
			this.appService.createCategory(categories);
			return "redirect:/new/category";
		}	
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Products oneProduct = this.appService.getOneProduct(id);
		System.out.println(oneProduct);
//		List<Categories> allCategories = this.appService.getAllCateg();
		model.addAttribute("product", oneProduct);
//		model.addAttribute("allCategories", allCategories);
		
		List<Categories> nonRelCat = this.appService.findNonRelatedCategories(oneProduct);
		model.addAttribute("nonRelCat", nonRelCat);
		
		return "ProductPage.jsp";
	}
	
	@PostMapping("/addCategoryToProduct/{id}")
	public String addCategoryToProduct(@PathVariable("id")Long prodId, @RequestParam("selected_category") Long category_id ) {
		this.appService.joinProductToCategory(prodId, category_id);
		return "redirect:/products/{id}";
		
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Categories oneCategory = this.appService.getOneCategory(id);
//		List<Products> allProducts = this.appService.getAllProd();
		model.addAttribute("category", oneCategory);
//		model.addAttribute("allProducts", allProducts);
		
		List<Products> nonRelProd = this.appService.findNonRelatedProducs(oneCategory);
		model.addAttribute("nonRelProd", nonRelProd);
		
		return "CategoryPage.jsp";
	}
	
	@PostMapping("/addProductToCategory/{id}")
	public String addProductToCategory(@PathVariable("id")Long categoryId, @RequestParam("selected_product") Long product_id ) {
		
	
//		System.out.println("Id of the category is this: " + categoryId);
//		System.out.println("Id of the product is this: " + product_id);
		this.appService.joinCategoryToProduct(categoryId, product_id);
		return "redirect:/categories/{id}";
		
	}
	

}
