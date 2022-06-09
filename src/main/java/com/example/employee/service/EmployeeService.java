package com.example.employee.service;

import java.util.List;

import com.example.employee.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAll();
	
	Employee getById(Long id);
	
	Employee create(Employee newTask);
	
	Employee update(Employee taskToUpdate);

}
