package com.repo.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.repo.Management.Model.ProductModel;
import com.repo.Management.Service.ServiceDAO;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ServiceDAO service;
	
	@PostMapping("/addproduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductModel product) {
		return service.addProduct(product);
	}
	
	@GetMapping("/getProductsByCategory/{categoryId}")
	public ResponseEntity<Object> getProductsByCategory(@PathVariable("categoryId") int categoryId) {
		return service.getProductsByCategory(categoryId);
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<Object> getProductByID(@PathVariable int productId) {
		return service.getProductByID(productId);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("productId") int productId) {
		return service.deleteProduct(productId);
	}
	
	@PostMapping("/buy")
	public ResponseEntity<Object> buyProduct(@RequestBody List<ProductModel> products) {
		return service.buyProduct(products);
	}
	
}
