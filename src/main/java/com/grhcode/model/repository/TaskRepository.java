package com.grhcode.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grhcode.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByTitle(String title);

}
