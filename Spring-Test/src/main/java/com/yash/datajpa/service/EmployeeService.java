package com.yash.datajpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmpByName(String name){
		return employeeRepository.findByName(name);
	}
}
