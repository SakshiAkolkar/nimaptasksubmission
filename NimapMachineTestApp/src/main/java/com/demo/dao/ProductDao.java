package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> 
{
	//this is the product repository which contains all the abstract methods
	Product save(Product p);
	
	List<Product> findAll();
	
	int deleteByPid(int pid);
	
	Product getProductByPid(int pid);
	
}