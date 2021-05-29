package com.repo.Management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid")
	private int productId;
	@Column(name="pname", nullable=false)
	private String productName;
	@Column(name="pdescription")
	private String productDescription;
	@Column(name="pimage")
	private String productImage;
	@Column(name="pprice", nullable=false)
	private Integer productPrice;
	@Column(name="pquantity", nullable=false)
	private Integer productQuantity;
	@Column(name="pthreshold", nullable=false)
	private Integer productThreshold;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private CategoryEntity category;
	
	public int getPid() {
		return productId;
	}
	public void setPid(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getProductThreshold() {
		return productThreshold;
	}
	public void setProductThreshold(int productThreshold) {
		this.productThreshold = productThreshold;
	}
//	public CategoryEntity getCategory() {
//		return category;
//	}
	
	public CategoryEntity findCategory() {
		return category;
	}
	
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
		
	public ProductEntity(String productName, String productDescription, String productImage, int productPrice,
			int productQuantity, int productThreshold, CategoryEntity category) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productThreshold = productThreshold;
		this.category = category;
	}
	
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public boolean isValid() {
//		if (this.productName == null || this.productPrice == null || this.productQuantity == null || this.productThreshold == null || this.category == null)
//			return false;
//		else 
//			return true;
//	}
	
}
