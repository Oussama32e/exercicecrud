package com.grhcode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grhcode.exception.ResourceNotFoundException;

import com.grhcode.model.Task;
import com.grhcode.model.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	public List<Task> showTask()
	{
		return taskRepository.findAll();
		// select * from formation

	}
	public Task addTask(Task t)
	{
		return taskRepository.save(t);

	}
	public Optional<Task> getTaskById(long id)
	{
	return  taskRepository.findById(id);	
	}
	public List<Task> getTaskByTitle(String Title)
	{
		return taskRepository.findByTitle(Title);
	}
	public ResponseEntity<?> deleteTask(long id)
	{
		 Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("task","id",id) );
		 taskRepository.delete(task);
	 
	 return ResponseEntity.ok().build();

	}
	

}
