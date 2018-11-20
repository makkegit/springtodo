package com.example.todo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
	private String mission, status;
	
	
	public Todo() {
	}
	
	public Todo(String mission, String status) {
		super();
		this.mission = mission;
		this.status = status;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMission() {
		return mission;
	}
	
	public void setMission(String mission) {
		this.mission = mission;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "Todo [id=" + id + ", mission=" + mission + ", status=" + status + "]";
	}
}
