package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService
{
	//this is the implementation class of CategoryService , all methods in CategoryService are implemented by this class(CategoryServiceImpl)
	@Autowired
	CategoryDao cd;

	@Override
	public Category save(Category c) {
		// TODO Auto-generated method stub
		return  cd.save(c);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}

	@Override
	public Category getCategoryByCid(int cid) {
		// TODO Auto-generated method stub
		return cd.getCategoryByCid(cid);
	}

	@Override
	public int deleteByCid(int cid) {
		// TODO Auto-generated method stub
		return cd.deleteByCid(cid);
	}
	
	 public Page<Category> getAllCategory(Pageable pageable) {
	        return cd.findAll(pageable);
	    }
}
