package com.example.todo.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.todo.domain.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
	
}