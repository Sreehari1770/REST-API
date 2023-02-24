package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Child;
import com.example.demo.Service.ApiService;


@RestController
public class ApiController {
	@Autowired
	ApiService service;
	
	@GetMapping("/child")
	public List<Child> Child(){
		return service.getChild();
	}
	
	@PostMapping("/child")
	public String addChild(@RequestBody Child child) {
		service.addChild(child);
		return "Added child"+ child.getBabyId();
	}
	
//	sorting
	@GetMapping("/child/{field}")
	public List<Child> ChildWithSort(@PathVariable String field){
		return service.getChildSorted(field);
	}
	
//	pagination
	@GetMapping("/child/{offset}/{pageSize}")
	public List<Child> ChildWithPagination(@PathVariable int offset,@PathVariable int pageSize){
		return service.getChildWithPagination(offset, pageSize);
	}
	
//	sorting and pagination
	@GetMapping("/child/{offset}/{pageSize}/{field}")
	public List<Child> getChildWithPaginationAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
	   return service.getChildWithPaginationAndSorting(offset, pageSize, field);	
	}
}
