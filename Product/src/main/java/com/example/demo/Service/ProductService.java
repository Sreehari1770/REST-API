package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    
    public String addProduct(Product product) {
    	repository.save(product);
    	return "Added";
    }
    
    public List<Product> getProducts(){
    	return repository.findAll();
    }
//    Sorting
    public List<Product> getProductsSorted(String field){
    	return repository.findAll(Sort.by(Sort.Direction.ASC,field));
    		
    }
//    pagination
    public List<Product> getProductsWithPagination(int offset,int pageSize){
    	Page<Product> page=repository.findAll(PageRequest.of(offset, pageSize));
    	return page.getContent();
    }
//    pagination and sorting
    public List<Product> getProductsWithPaginationAndSorting(int offset,int pageSize, String field){
    	PageRequest paging=PageRequest.of(offset, pageSize,Sort.by(field));
    	Page<Product> page=repository.findAll(paging);
    	return page.getContent();
    }
    
}
