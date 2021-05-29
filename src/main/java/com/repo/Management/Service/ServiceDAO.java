package com.repo.Management.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.repo.Management.Model.CategoryModel;
import com.repo.Management.Model.ProductModel;

public interface ServiceDAO {

	public ResponseEntity<Object> addProduct(ProductModel product);
	
	public ResponseEntity<Object> addCategory(CategoryModel category);
	
	public ResponseEntity<Object> getProductsByCategory(int categoryId);
	
	public ResponseEntity<Object> getCategoryByProduct(int productId);
	
	public ResponseEntity<Object> getAllProducts();
	
	public ResponseEntity<Object> getAllCategories();
	
	public ResponseEntity<Object> deleteProduct(int productId);
	
	public ResponseEntity<Object> deleteCategory(int categoryId);

	public ResponseEntity<Object> getProductByID(int productId);

	public ResponseEntity<Object> getCategoryByID(int categoryId);

	public ResponseEntity<Object> buyProduct(List<ProductModel> products);
	
	
	
}
