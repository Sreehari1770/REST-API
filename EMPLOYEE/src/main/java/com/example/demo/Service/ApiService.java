package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Employee;
import com.example.demo.Repositories.EmployeeRepo;



@Service

public class ApiService {

@Autowired

EmployeeRepo repository;

public String addEmployee(Employee employee) {

repository.save(employee);

return "Added";

}

public List<Employee>getEmployee(){

return repository.findAll();

}

}