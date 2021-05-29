package com.repo.Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repo.Management.Service.ServiceDAO;

@RestController
public class UnAuthenticatedController {
	
	@Autowired
	private ServiceDAO service;

	@GetMapping("/products")
	public ResponseEntity<Object> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Object> getAllCategories() {
		return service.getAllCategories();
	}
	
	
}
