package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

	  List<Product> findAllProductByCategoryId(@Param("id")Integer id);
}
