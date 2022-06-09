package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(Long id) {

		Optional<Employee> employeeRef = employeeRepository.findById(id);
		return employeeRef.isPresent() ? employeeRef.get() : null;
	}

	@Override
	public Employee create(Employee newTask) {

		return employeeRepository.persist(newTask);
	}

	@Override
	public Employee update(Employee taskToUpdate) {

		return employeeRepository.update(taskToUpdate);
	}

}
