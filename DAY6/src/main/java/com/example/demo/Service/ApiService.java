package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Child;
import com.example.demo.Repositories.ChildRepo;





@Service
public class ApiService {

    @Autowired
    ChildRepo repository;
    
    public String addChild(Child child) {
    	repository.save(child);
    	return "Added";
    }
    
    public List<Child> getChild(){
    	return repository.findAll();
    }
//    Sorting
    public List<Child> getChildSorted(String field){
    	return repository.findAll(Sort.by(Sort.Direction.ASC,field));
    		
    }
//    pagination
    public List<Child> getChildWithPagination(int offset,int pageSize){
    	Page<Child> page=repository.findAll(PageRequest.of(offset, pageSize));
    	return page.getContent();
    }
//    pagination and sorting
    public List<Child> getChildWithPaginationAndSorting(int offset,int pageSize, String field){
    	PageRequest paging=PageRequest.of(offset, pageSize,Sort.by(field));
    	Page<Child> page=repository.findAll(paging);
    	return page.getContent();
    }
}
