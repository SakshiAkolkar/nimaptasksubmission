package com.demo.controller;

import java.util.List;

import org.apache.catalina.filters.CsrfPreventionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.CDATASection;

import com.demo.model.Category;
import com.demo.services.CategoryService;
import com.demo.services.CategoryServiceImpl;

@RestController
@RequestMapping
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	//This method inserts new records into category table 
	@PostMapping(value = "/api/categories")
	public Category insertCategory(@RequestBody Category c)
	{
		return categoryService.save(c);
	}
	//This method retrieves all records from category table 
	@GetMapping(value="/api/categories")
	public List<Category> getAllCategory()
	{
		return categoryService.findAll();
	}
	//This method fetch the record of that particular id
	@GetMapping(value="/api/categories/{cid}")
	public Category getByCid(@PathVariable int cid)
	{
		return categoryService.getCategoryByCid(cid);
	}
	//This method delete the record of that particular id

	@DeleteMapping(value="/api/categories/{cid}")
	public int deleteCategory(@PathVariable int cid)
	{
		return categoryService.deleteByCid(cid);
	}
	
	//This method update the record of the particular id
	@PutMapping(value = "/api/categories/{cid}")
	public Category updateById(@PathVariable int cid, @RequestBody Category c)
	{
		Category c1 = categoryService.getCategoryByCid(cid);
		c1.setCid(c.getCid());
		c1.setCname(c.getCname());
		return categoryService.save(c1);
	}
	
	 //this method used for pagination(5 records will be displayed on each page)
	 //for this we need to give page number as parameter
	 @GetMapping(value = "api/categories/")
	    public ResponseEntity<Page<Category>> getAllProducts(
	            @RequestParam("page") int page) 
	 {

	        PageRequest pageable =  PageRequest.of(page, 5);
	        
				Page<Category> category = categoryService.getAllCategory(pageable);
			

	        return new ResponseEntity<>(category, HttpStatus.OK);
	    }

}
