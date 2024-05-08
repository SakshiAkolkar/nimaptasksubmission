package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.services.ProductService;

@RestController
@RequestMapping
public class ProductController 
{

	@Autowired
	ProductService productService;
	//this method inserts a new record into Product table as it includes category_id as foreign key it needs a category object so that we need to give category object  
	@PostMapping(value = "/api/products/{cid}")
	public Product newProductAdd(@PathVariable int cid,@RequestBody Product p)
	{
		return productService.createProduct(p, cid);
		
	}
	//this method fetch all the records from Product table
	@GetMapping(value = "/api/products")
	public List<Product> getAllProduct()
	{
		return productService.findAll();
	}
	//this method delete the product by id 
	@DeleteMapping(value="/api/products/{pid}")
	public int deleteProduct(@PathVariable int pid)
	{
		return productService.deleteByPid(pid);
	}
	//this method fetch the record from Product table
	@GetMapping(value="/api/products/{pid}")
	public Product getByPid(@PathVariable int pid)
	{
		return productService.getProductByPid(pid);
	}
	//this method update the record by id 
	@PutMapping(value = "/api/products/{pid}/{cid}")
	public Product updateProduct(@RequestBody Product p , @PathVariable int pid, @PathVariable int cid)
	{
		
		return productService.updateProductByPid(p, pid, cid);
	}
	//this method retrieves 5 records on each page as we mentioned page size is 5 
	@GetMapping(value = "api/product/")
	public ResponseEntity<Page<Product>> getAllProducts(
	            @RequestParam("page") int page) 
	 {

	        PageRequest pageable =  PageRequest.of(page, 5);
	        
				Page<Product> product = productService.getAllProduct(pageable);
			

	        return new ResponseEntity<>(product, HttpStatus.OK);
	    }
}
