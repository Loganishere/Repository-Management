package com.repo.Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repo.Management.Entity.CategoryEntity;

@Repository
public interface CategoryRespository extends JpaRepository<CategoryEntity, Integer>{

}
