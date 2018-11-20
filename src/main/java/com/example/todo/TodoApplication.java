package com.example.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoRepository;
import com.example.todo.domain.User;
import com.example.todo.domain.UserRepository;

@SpringBootApplication
public class TodoApplication {
	private static final Logger log = LoggerFactory.getLogger(TodoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner todoDemo(UserRepository urepository, TodoRepository trepository) {
		return (args) -> {			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			// Create todo
			log.info("One todo to save them all!");
			trepository.save(new Todo("This project", "Almost done!"));
			
			
		};
	}	
}
