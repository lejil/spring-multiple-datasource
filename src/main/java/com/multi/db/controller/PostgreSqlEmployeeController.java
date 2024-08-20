/**
 * 
 */
package com.multi.db.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.db.model.Employee;
import com.multi.db.service.PostgreSqlEmployeeService;

/**
 * @author Lejil
 *
 */
@RestController
@RequestMapping("postgresql")
public class PostgreSqlEmployeeController {

	@Autowired
	private PostgreSqlEmployeeService postgrSqlEmployeService;

	// Create a new employee
	@PostMapping("employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = postgrSqlEmployeService.createEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
	}

	// Get an employee by ID
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> employee = postgrSqlEmployeService.getEmployeeById(id);
		return employee.map(emp -> new ResponseEntity<>(emp, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}