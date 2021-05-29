package com.repo.Management.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.repo.Management.Entity.CategoryEntity;

public class CategoryModel {

	private Integer cId;
	private String cName;
	private String cDesc;
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDesc() {
		return cDesc;
	}
	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}
	
	public CategoryModel() {
		super();
	}
	
	@JsonIgnore
	public boolean isValid() {
		if (this.cName == null)
			return false;
		else
			return true;
	}
	
	@JsonIgnore
	public CategoryEntity createDBObject() {
		CategoryEntity c = new CategoryEntity();
		c.setCategoryName(this.cName);
		
		if (this.cDesc != null)
			c.setCategoryDescription(this.cDesc);
		
		return c;
	}
	
	public void EntityToModel(CategoryEntity category) {
		this.cId = category.getCategoryId();
		this.cName = category.getCategoryName();
		
		if (category.getCategoryDescription() != null)
			this.cDesc = category.getCategoryDescription();
	}
}
