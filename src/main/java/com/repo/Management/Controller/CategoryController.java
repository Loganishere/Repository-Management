package com.repo.Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repo.Management.Model.CategoryModel;
import com.repo.Management.Service.ServiceDAO;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private ServiceDAO service;

	@PostMapping("/addcategory")
	public ResponseEntity<Object> addCategory(@RequestBody CategoryModel category) {
		return service.addCategory(category);
	}
	
	@GetMapping("/getCategoryByProduct/{productId}")
	public ResponseEntity<Object> getCategoryByProducts(@PathVariable("productId") int productId) {
		return service.getCategoryByProduct(productId);
	}
	
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<Object> getCategoryByID(@PathVariable("categoryId") int categoryId) {
		return service.getCategoryByID(categoryId);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<Object> deleteCategory(@PathVariable("categoryId") int categoryId) {
		return service.deleteCategory(categoryId);
	}
	
}
