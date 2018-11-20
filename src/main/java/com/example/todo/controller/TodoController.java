package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoRepository;

@Controller
public class TodoController {
	
	@Autowired
	private TodoRepository trepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }		
	
	// Show all todos
    @RequestMapping(value = "/todos")
    public String todoList(Model model) {	
        model.addAttribute("todolist", trepository.findAll());
        return "todos";
    }

    // Add todo
    @RequestMapping(value = "/add")
    public String addTodo(Model model){
    	model.addAttribute("todo", new Todo());
        return "addtodo";
    }     
    
    // Save todo
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Todo todo){
        trepository.save(todo);
        return "redirect:/todos";
    }
    // Edit todo
    @RequestMapping(value = "/edit/{id}")
    public String editTodo(@PathVariable("id") Long todoId, Model model) {
    	model.addAttribute("todo", trepository.findById(todoId));
    	return "editodo";
    }

   
    // Delete todo
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTodo(@PathVariable("id") Long todoId, Model model) {
    	trepository.deleteById(todoId);
        return "redirect:/todos";
    }
}
