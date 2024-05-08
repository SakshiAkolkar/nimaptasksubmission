package com.demo.services;

import java.util.List;
import java.util.Locale.Category;

import javax.print.attribute.standard.PDLOverrideSupported;

import org.hibernate.dialect.function.LpadRpadPadEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.w3c.dom.CDATASection;

import com.demo.dao.ProductDao;
import com.demo.model.Product;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{	
	//this is the implementation class of product service , all methods in ProductService are implemented by this class(ProductServiceImpl)
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryService cService;
	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		return productDao.save(p);
	}
	
	public Product createProduct(Product p, int cid)
	{
	com.demo.model.Category c = cService.getCategoryByCid(cid);
		p.setCategory(c);
	
		
		return productDao.save(p);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public int deleteByPid(int pid) {
		// TODO Auto-generated method stub
		return productDao.deleteByPid(pid);
	}

	@Override
	public Product getProductByPid(int pid) {
		// TODO Auto-generated method stub
		return productDao.getProductByPid(pid);
	}

	@Override
	public Product updateProductByPid(Product p1, int pid, int cid) {
		
		com.demo.model.Category c = cService.getCategoryByCid(cid);
	Product	p = productDao.getProductByPid(pid);
		p1.setCategory(c);
		
		return productDao.save(p1);
	}

	@Override
	public Page<Product> getAllProduct(Pageable pageable) {
		
		return productDao.findAll(pageable);
	}
	


}
