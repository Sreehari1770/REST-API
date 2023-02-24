package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.Book;

public interface BookRepo extends CrudRepository<Book,Integer>{

}
