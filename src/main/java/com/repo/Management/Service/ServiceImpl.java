package com.repo.Management.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.repo.Management.Entity.CategoryEntity;
import com.repo.Management.Entity.ProductEntity;
import com.repo.Management.ExceptionHandling.BuyQuantityInvalidException;
import com.repo.Management.ExceptionHandling.CategoryNotFoundException;
import com.repo.Management.ExceptionHandling.EmptyJsonException;
import com.repo.Management.ExceptionHandling.ProductNotFoundException;
import com.repo.Management.ExceptionHandling.RequiredFieldsEmptyException;
import com.repo.Management.Model.CategoryModel;
import com.repo.Management.Model.ProductModel;
import com.repo.Management.Model.ResponseModel;
import com.repo.Management.Repository.CategoryRespository;
import com.repo.Management.Repository.ProductRespository;

@Component
public class ServiceImpl implements ServiceDAO {
	
	@Autowired
	private ProductRespository productRepo;
	
	@Autowired
	private CategoryRespository categoryRepo;
	
	@Override
	public ResponseEntity<Object> addProduct(ProductModel product) {
		if(!product.isValid())
			throw new RequiredFieldsEmptyException();
		else {
			ProductEntity p = new ProductEntity();
			p = product.createDBObject();
			p = productRepo.save(p);
			product.setpId(p.getPid());
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		}
	}
	
	@Override
	public ResponseEntity<Object> addCategory(CategoryModel category) {
		if(!category.isValid())
			throw new RequiredFieldsEmptyException();
		else {
			CategoryEntity c = new CategoryEntity();
			c = category.createDBObject();
			c = categoryRepo.save(c);
			category.setcId(c.getCategoryId());
			return new ResponseEntity<Object>(category, HttpStatus.OK);
		}
	}
	
	@Override
	public ResponseEntity<Object> getProductsByCategory(int categoryId) {
		try {
			CategoryEntity category = categoryRepo.getById(categoryId);
			return new ResponseEntity<Object>(category.findProducts(), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new CategoryNotFoundException(); 
		}
	}

	@Override
	public ResponseEntity<Object> getCategoryByProduct(int productId) {
		try {
			ProductEntity product = productRepo.getById(productId);
			return new ResponseEntity<Object>(product.findCategory(), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new ProductNotFoundException(); 
		}
	}

	@Override
	public ResponseEntity<Object> getAllProducts() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		try {
			products = productRepo.findAll();
			return new ResponseEntity<Object>(products, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new ProductNotFoundException();
		}
	}
	
	@Override
	public ResponseEntity<Object> getAllCategories() {
		List<CategoryEntity> categories = new ArrayList<CategoryEntity>();
		try {
			categories = categoryRepo.findAll();
			return new ResponseEntity<Object>(categories, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new ProductNotFoundException();
		}
	}

	@Override
	public ResponseEntity<Object> deleteProduct(int productId) {
		if (productRepo.existsById(productId)) {
			productRepo.deleteById(productId);
			return new ResponseEntity<Object>(new ResponseModel("200", "Product Deleted Successfully!"), HttpStatus.OK);
		}
		else 
			throw new ProductNotFoundException();
	}

	@Override
	public ResponseEntity<Object> deleteCategory(int categoryId) {
		if (categoryRepo.existsById(categoryId)) {
			categoryRepo.deleteById(categoryId);
			return new ResponseEntity<Object>(new ResponseModel("200", "Category Deleted Successfully!"), HttpStatus.OK);
		}
		else 
			throw new CategoryNotFoundException();
	}

	@Override
	public ResponseEntity<Object> getProductByID(int productId) {
		try {
			return new ResponseEntity<Object>(productRepo.getById(productId), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new ProductNotFoundException();
		}
	}

	@Override
	public ResponseEntity<Object> getCategoryByID(int categoryId) {
		try {
			return new ResponseEntity<Object>(categoryRepo.getById(categoryId), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			throw new CategoryNotFoundException();
		}
	}

	@Override
	public ResponseEntity<Object> buyProduct(List<ProductModel> products) {
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		if (products.size() <= 0)
			throw new EmptyJsonException();
		for (ProductModel product : products) {
			if (product.isBuyValid()) {
				try {
					ProductEntity p = productRepo.getById(product.getpId());
					if (p.getProductQuantity() > product.getpQuantity()) {
						p.setProductQuantity(p.getProductQuantity() - product.getpQuantity());
						entities.add(p);
					}
					else 
						throw new BuyQuantityInvalidException();
				} catch (EntityNotFoundException e) {
					throw new ProductNotFoundException();
				}
			}
			else
				throw new RequiredFieldsEmptyException();
		}
		productRepo.saveAll(entities);
		return new ResponseEntity<>(new ResponseModel("200", "Products Bought Successfully!"), HttpStatus.OK);
	}


}
