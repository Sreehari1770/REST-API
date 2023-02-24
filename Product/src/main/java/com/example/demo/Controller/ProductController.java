package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	
	@GetMapping("/product")
	public List<Product> products(){
		return service.getProducts();
	}
	
	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		service.addProduct(product);
		return "Added product"+ product.getId();
	}
	
//	sorting
	@GetMapping("/product/{field}")
	public List<Product> productWithSort(@PathVariable String field){
		return service.getProductsSorted(field);
	}
	
//	pagination
	@GetMapping("/product/{offset}/{pageSize}")
	public List<Product> productWithPagination(@PathVariable int offset,@PathVariable int pageSize){
		return service.getProductsWithPagination(offset, pageSize);
	}
	
//	sorting and pagination
	@GetMapping("/product/{offset}/{pageSize}/{field}")
	public List<Product> getProductWithPaginationAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
	   return service.getProductsWithPaginationAndSorting(offset, pageSize, field);	
	}
	
	
}
