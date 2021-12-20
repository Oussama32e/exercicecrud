package com.grhcode.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grhcode.exception.ResourceNotFoundException;
import com.grhcode.model.Employee;
import com.grhcode.model.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	public List<Employee> showEmployee()
	{
		return employeeRepository.findAll();
		// select * from formation

	}
	public Employee addEmployee(Employee f)
	{
		return employeeRepository.save(f);

	}
	public Optional<Employee> getEmployeeById(long id)
	{
	return  employeeRepository.findById(id);	
	}
	
	public Optional<Employee> getEmployeeByNomAndPrenom(String nom,String prenom)
	{
		return employeeRepository.findByNomAndPrenom(nom,prenom);
	}
	
	
	public ResponseEntity<?> deleteEmployee(long id)
	{
		 Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee","id",id) );
		 employeeRepository.delete(employee);
	 
	 return ResponseEntity.ok().build();

	}
	
	

}
