package com.grhcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grhcode.model.Task;

@RestController
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	
	@GetMapping("task")
	public List<Task> getFormations()
	{
		return taskService.showTask();
	}
	
	@PostMapping("/addTask")
	public Task addTask(@Valid @RequestBody Task t)
	{
	return taskService.addTask(t);	
	}
	
	
	@GetMapping("task/{id}")
	public Optional<Task> getTaskById(@PathVariable long id)
	{
		return taskService.getTaskById(id);
	}
	
	

	@DeleteMapping("/task/{id}")
	public void deleteStudent(@PathVariable long id) {

	taskService.deleteTask(id);
	}


}
