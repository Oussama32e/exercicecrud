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

import com.grhcode.model.Employee;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("employee")
	public List<Employee> getEmployee()
	{
		return employeeService.showEmployee();
	}
	
	@GetMapping("employeeby/{nom}{prenom}")
	public Optional<Employee> getEmployeeByNomAndPrenom(@PathVariable String nom,String prenom)
	{
		return employeeService.getEmployeeByNomAndPrenom(nom,prenom);
		
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@Valid @RequestBody Employee e)
	{
	return employeeService.addEmployee(e);	
	}
	
	
	@GetMapping("employee/{id}")
	public Optional<Employee> getTaskById(@PathVariable long id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	

	@DeleteMapping("/employee/{id}")
	public void deleteStudent(@PathVariable long id) {

		employeeService.deleteEmployee(id);
	}


}
