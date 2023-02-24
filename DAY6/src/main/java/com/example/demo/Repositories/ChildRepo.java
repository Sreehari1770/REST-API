package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.Child;

public interface ChildRepo extends JpaRepository<Child,Integer>{

}
