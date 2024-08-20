/**
 * 
 */
package com.multi.db.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.db.model.Employee;

/**
 * @author Lejil
 *
 */
@Repository
public interface PostgreSqlEmployeeRepository extends JpaRepository<Employee, Long> {

}
