package com.repo.Management.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cid")
	private int categoryId;
	@Column(name="cname", nullable=false)
	private String categoryName;
	@Column(name="cdescription")
	private String categoryDescription;
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

//	public List<ProductEntity> getProducts() {
//		return products;
//	}

	public List<ProductEntity> findProducts() {
		return products;
	}
	
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public CategoryEntity(String categoryName, String categoryDescription, List<ProductEntity> products) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.products = products;
	}

	public CategoryEntity() {
		super();
	}
	
	public boolean isValid() {
		if (this.categoryName == null)
			return false;
		else
			return true;
	}
	
	
}
