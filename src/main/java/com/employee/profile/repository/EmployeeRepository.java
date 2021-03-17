package com.employee.profile.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.profile.employeeDetails.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	public Employee findById(int id);

}
