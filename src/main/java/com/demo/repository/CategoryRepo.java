package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.beans.Category;


@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> { 

}
