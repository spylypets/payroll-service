package com.example.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET) 
	@ResponseBody
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}") 
	@ResponseBody
	public Employee getById(@PathVariable(name="id") Long id) {
		return employeeService.getById(id);
	}
	
	@PostMapping
	Employee create(@RequestBody Employee newEmployee) {
		
		return employeeService.create(newEmployee);
	}
	
	@PutMapping
	Employee update(@RequestBody Employee employeeToUpdate) {
		
		return employeeService.update(employeeToUpdate);
	}

}
