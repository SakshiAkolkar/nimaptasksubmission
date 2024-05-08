package com.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>
{
	//this is the category repository which contains all the abstract methods 
	Category save(Category c);
	List<Category> findAll();
	Category getCategoryByCid(int cid);
	int deleteByCid(int cid);
	//Page<Category> findAll(Pageable pageable);
	
}
