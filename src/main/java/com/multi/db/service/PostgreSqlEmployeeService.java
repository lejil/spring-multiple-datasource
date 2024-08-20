/**
 * 
 */
package com.multi.db.service;

import java.util.Optional;

import com.multi.db.model.Employee;

/**
 * @author Lejil
 *
 */
public interface PostgreSqlEmployeeService {

	Employee createEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Long id);
}
