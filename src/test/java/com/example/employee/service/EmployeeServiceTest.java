package com.example.employee.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import com.example.employee.model.Employee;
import com.example.employee.model.Roles;
import com.example.employee.repository.EmployeeRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeServiceTest {
	
	@Autowired
    EmployeeRepository employeeRepository;
	
	@Autowired
    EmployeeService employeeService;

    @BeforeEach
    void beforeEach() {
    	employeeRepository.persistAll(generateEmployees());
    }
    
    @AfterEach
    void afterEach() {
    	employeeRepository.deleteAll();
    }
    
    @Test
    void testGetAll() {
    	
    	List<Employee> employees = employeeService.getAll();
    	
    	assertEquals(3, employees.size());
    }
    
    @Test
    void testGetById() {
    	
    	Employee homer = employeeRepository.findByName("Homer Simpson");
    	Employee test = employeeService.getById(homer.getId());
    	
    	assertAll(
                () -> assertNotNull(test),
                () -> assertEquals("Homer Simpson", test.getName()),
                () -> assertEquals(Roles.TESTER, test.getRole())
        );
    }
    
    @Test
    void testCreateEmployee() {
    	
    	Employee frodo = new Employee(null, "Frodo Buggins", Roles.TESTER);
    	employeeService.create(frodo);
    	
    	List<Employee> employees = employeeRepository.findAll(Sort.by("name"));
    	
    	assertAll(
                () -> assertEquals(4, employees.size()),
                () -> assertEquals("Frodo Buggins", employees.get(1).getName()),
                () -> assertEquals(Roles.TESTER, employees.get(1).getRole())
        );
    }
    
    @Test
    void testModifyEmployee() {
    	
    	Employee homer = employeeRepository.findByName("Homer Simpson");
    	assertEquals(Roles.TESTER, homer.getRole());
    	homer.setRole(Roles.ADMINISTRATOR);
    	employeeService.update(homer);
    	Employee homer2 = employeeRepository.findByName("Homer Simpson");
    	assertEquals(Roles.ADMINISTRATOR, homer2.getRole());
    }
    
    private static List<Employee> generateEmployees() {
		
    	Employee emp1 = new Employee(null, "John Dow", Roles.DEVELOPER);
    	Employee emp2 = new Employee(null, "Homer Simpson", Roles.TESTER);
    	Employee emp3 = new Employee(null, "Cathy Simpson", Roles.ADMINISTRATOR);
    	
		return Arrays.asList(emp1, emp2, emp3);
	}

}
