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
public interface MySqlEmployeeService {

	Employee createEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Long id);

}
