package com.demo.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "product")
public class Product   {
	
	
	private int id;
	private String prodname;
	private long prodprice;
	private int prodquantity;
	private Set<Category> categories = new HashSet<Category>();
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	public Product(int id, String prodname, long prodprice, int prodquantity, Set<Category> categories) {
		super();
		this.id = id;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodquantity = prodquantity;
		this.categories = categories;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "category_product", catalog = "test_db", 
	joinColumns = {
			@JoinColumn(name="product_id", nullable = false, updatable = false)
					},
	inverseJoinColumns = 
			{ @JoinColumn(name = "category_id", nullable = false, updatable = false) }
			)
	
	
		public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Column
	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	@Column
	public long getProdprice() {
		return prodprice;
	}

	public void setProdprice(long prodprice) {
		this.prodprice = prodprice;
	}

	@Column
	public int getProdquantity() {
		return prodquantity;
	}

	public void setProdquantity(int prodquantity) {
		this.prodquantity = prodquantity;
	}





	
	
}
