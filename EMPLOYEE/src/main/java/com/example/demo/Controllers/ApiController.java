package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Employee;
import com.example.demo.Service.ApiService;


@RestController
public class ApiController {
@Autowired
ApiService service;

@PostMapping("/Employee")
public String add(@RequestBody Employee employee) {
return service.addEmployee(employee);
}

@GetMapping("/Employee")
public List<Employee> get(){
return service.getEmployee();
}
}