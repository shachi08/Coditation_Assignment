package com.demo.beans;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "category")
public class Category  {


	private int id;
	private String catgryname;
	private Set<Product> products = new HashSet<Product>();
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "category_product", catalog = "test_db", 
	joinColumns = {
			@JoinColumn(name="category_id", nullable = false, updatable = false)},
	inverseJoinColumns = {
					@JoinColumn(name = "product_id", nullable = false, updatable = false) })
	
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
    @ManyToOne
    private Category parent_catgry;
    @OneToMany(mappedBy="parent")
    private Collection<Category> child_catgry;
    
    
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(Integer id, String catgryname, Category parent_catgry, Collection<Category> child_catgry) {
		this.id = id;
		this.catgryname = catgryname;
		this.parent_catgry = parent_catgry;
		this.child_catgry = child_catgry;
	}



	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "catgryid", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getCatgryname() {
		return catgryname;
	}


	

	public void setCatgryname(String catgryname) {
		this.catgryname = catgryname;
	}



	public Category getParent_catgry() {
		return parent_catgry;
	}


	public void setParent_catgry(Category parent_catgry) {
		this.parent_catgry = parent_catgry;
	}


	public Collection<Category> getChild_catgry() {
		return child_catgry;
	}


	public void setChild_catgry(Collection<Category> child_catgry) {
		this.child_catgry = child_catgry;
	}


    
    
}
