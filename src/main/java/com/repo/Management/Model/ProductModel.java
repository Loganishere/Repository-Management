package com.repo.Management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.repo.Management.Entity.CategoryEntity;
import com.repo.Management.Entity.ProductEntity;

public class ProductModel {

	private Integer pId;
	private String pName;
	private String pDescription;
	private String pImage;
	private Integer pPrice;
	private Integer pQuantity;
	private Integer pThreshold;
	private CategoryModel pCategory;
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public int getpThreshold() {
		return pThreshold;
	}
	public void setpThreshold(int pThreshold) {
		this.pThreshold = pThreshold;
	}
	public CategoryModel getpCategory() {
		return pCategory;
	}
	public void setpCategory(CategoryModel pCategory) {
		this.pCategory = pCategory;
	}
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnore
	public boolean isValid() {
		if (this.pName == null || this.pPrice == null || this.pQuantity == null || this.pThreshold == null || this.pCategory == null)
			return false;
		else 
			return true;
	}
	
	@JsonIgnore
	public ProductEntity createDBObject() {
		ProductEntity p = new ProductEntity();
		CategoryEntity c = new CategoryEntity();
		
		p.setProductName(this.pName);
		p.setProductPrice(this.pPrice);
		p.setProductQuantity(this.pQuantity);
		p.setProductThreshold(this.pThreshold);
		c.setCategoryId(this.pCategory.getcId());
		p.setCategory(c);
		
		if (this.pDescription != null)
			p.setProductDescription(this.pDescription);
		if (this.pImage != null)
			p.setProductImage(this.pImage);
		
		return p;
	}
	
	@JsonIgnore
	public boolean isBuyValid() {
		if (this.pId == null || this.pQuantity == null)
			return false;
		else
			return true;
	}
	
	public void EntityToModel(ProductEntity pEntity) {
		CategoryModel c = new CategoryModel();
		this.pId = pEntity.getPid();
		this.pName = pEntity.getProductName();
		this.pPrice = pEntity.getProductPrice();
		this.pQuantity = pEntity.getProductQuantity();
		this.pThreshold = pEntity.getProductThreshold();
		c.EntityToModel(pEntity.findCategory());
		this.pCategory = c;
		
		try {
			this.pDescription = pEntity.getProductDescription();
		} catch (NullPointerException e) {
			
		}
		try {
			this.pImage = pEntity.getProductImage();
		} catch(NullPointerException e) {
			
		}
	}
}
