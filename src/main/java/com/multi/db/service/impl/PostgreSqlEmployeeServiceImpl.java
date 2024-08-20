/**
 * 
 */
package com.multi.db.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.db.exception.EmployeeServiceException;
import com.multi.db.model.Employee;
import com.multi.db.postgresql.repository.PostgreSqlEmployeeRepository;
import com.multi.db.service.PostgreSqlEmployeeService;

/**
 * @author Lejil
 *
 */
@Service
public class PostgreSqlEmployeeServiceImpl implements PostgreSqlEmployeeService {


	@Autowired
	PostgreSqlEmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return Optional.ofNullable(employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeServiceException(id)));
	}

}
