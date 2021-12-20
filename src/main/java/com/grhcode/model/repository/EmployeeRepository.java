package com.grhcode.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grhcode.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByNomAndPrenom(String nom,String prenom);
	
	

}
