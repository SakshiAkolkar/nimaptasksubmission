package com.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;


public interface CategoryService 
{
	//this is the service layer of category , all the abstract methods present in this interface are implemented by CategoryServiceImpl
	Category save(Category c);
	List<Category> findAll();
	Category getCategoryByCid(int cid);
	int deleteByCid(int cid);
	Page<Category> getAllCategory(Pageable pageable);
}

