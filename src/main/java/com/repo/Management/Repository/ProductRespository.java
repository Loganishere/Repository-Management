package com.repo.Management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repo.Management.Entity.ProductEntity;

@Repository
public interface ProductRespository extends JpaRepository<ProductEntity, Integer> {

	public List<ProductEntity> findByCategory(int categoryId);
	
}
