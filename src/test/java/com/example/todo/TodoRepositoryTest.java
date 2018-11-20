package com.example.todo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {
	

	    @Autowired
	    private TodoRepository trepository;

	
	    @Test
	    public void createNewTodo() {
	    	Todo todo = new Todo("project", "done");
	    	trepository.save(todo);
	    	assertThat(todo.getId()).isNotNull();
	    }    

	}
