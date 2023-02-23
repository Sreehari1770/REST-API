package com.example.demo.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Students;
import com.example.demo.Repositories.StudentRepo;



@Service
public class ApiService {

	@Autowired
	StudentRepo repository;
	
	public String addStudent(Students students) {
		repository.save(students);
		return "Added";
	}
	public List<Students> getStudent(){
		return (List<Students>) repository.findAll();
	}
	public Optional<Students> getStudentById(int id){
		return repository.findById(id);
	}
	public String updateStudent(Students students) {
		repository.save(students);
		return "Updated";
	}
	public String deleteStudentById(int id) {
		repository.deleteById(id);
		return "student deleted";
	}
}
