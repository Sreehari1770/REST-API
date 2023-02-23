package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Students;
import com.example.demo.Service.ApiService;

@RestController
public class ApiController {


	@Autowired
	ApiService service;
	
	@PostMapping("/student")
	public String add(@RequestBody Students students) {
		return service.addStudent(students);
	}
	
	@GetMapping("/student")
	public List<Students> get(){
		return service.getStudent();
	}
	@GetMapping("/student/{id}")
	public Optional<Students> readById(@PathVariable int id){
		return service.getStudentById(id);
	}
	@PutMapping("/student")
	public String update(@RequestBody Students student) {
		return service.updateStudent(student);
	}
	@DeleteMapping("/customer")
	public String delete(@RequestParam int id ) {
		return service.deleteStudentById(id);
	}
}