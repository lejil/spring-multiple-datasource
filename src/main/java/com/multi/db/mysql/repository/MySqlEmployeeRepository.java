/**
 * 
 */
package com.multi.db.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.db.model.Employee;

/**
 * @author Lejil
 *
 */
@Repository
public interface MySqlEmployeeRepository extends JpaRepository<Employee, Long> {

}
