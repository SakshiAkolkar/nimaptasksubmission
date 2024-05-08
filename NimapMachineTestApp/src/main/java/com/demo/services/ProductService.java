package com.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Category;
import com.demo.model.Product;


public interface ProductService 
{
	//this is the service layer of product , all the abstract methods present in this interface are implemented by ProductServiceImpl
	Product save(Product p);
	Product createProduct(Product p, int cid);

	List<Product> findAll();
	int deleteByPid(int pid);
	Product getProductByPid(int pid);
	Product updateProductByPid(Product p, int pid, int cid);
	Page<Product> getAllProduct(Pageable pageable);
}
