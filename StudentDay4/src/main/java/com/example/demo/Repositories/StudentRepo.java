package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Students;

@Repository
public interface StudentRepo extends CrudRepository<Students,Integer>{

}

