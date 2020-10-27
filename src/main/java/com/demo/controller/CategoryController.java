package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.repository.CategoryRepo;
import com.demo.repository.ProductRepo;




@RestController
@RequestMapping("/coditationAssingment")
public class CategoryController {

	@Autowired
	private Category categry;
	
	@Autowired
	private Product prodct;
	
	@Autowired
	private CategoryRepo crepo;
	
	@Autowired
	private ProductRepo prepo;
	
	

	
	

	//Task1-Add a Category
	@PostMapping("newCategory")
	public Category postCategory(@Validated @RequestBody Category categry)
	{
		crepo.save(categry);
		return categry;
	}
		
		//Task2-Add a Product
	@PostMapping("newProduct")
	public Product postProduct(@Validated @RequestBody Product prodct)
	{
		prepo.save(prodct);
		return prodct;
	}
		
		//Task 3-getAll categories..
		@GetMapping("getAllCategory")
		public List<Category> listCategory()
		{
			System.out.println("getting all categories......."+(List<Category>) crepo.findAll());
			return  (List<Category>) crepo.findAll();
			
		}

		
		
		//Task 4-Get all products by a category.
		@GetMapping("CategoryById/{id}")
		public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable(value="id") int id)
		{
			List<Product> prodct= prepo.findAllProductByCategoryId(id);
			return ResponseEntity.ok().body(prodct);
		
		}
		
		
		
	//Task 5-Upadte Product Details...
	@PutMapping("product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value="id") int id,@RequestBody Product productDetails)
	{
		Product prodct= prepo.findById(id).orElse(null);
		prodct.setId(productDetails.getId());
		prodct.setProdname(productDetails.getProdname());
		prodct.setProdprice(productDetails.getProdprice());
		prodct.setProdquantity(productDetails.getProdquantity());
		prepo.save(prodct);
		return ResponseEntity.ok().body(prodct);
	}
}
