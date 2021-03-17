package com.employee.profile.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.profile.employeeDetails.Employee;
import com.employee.profile.repository.EmployeeRepository;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	//get all employye detail
	public List<Employee> getAllEmployees(){
		List<Employee> list = (List<Employee>)this.employeeRepository.findAll();
		return list;
	}
	
	
	//get single employee detail
	public Employee getEmployeeById(int id) {
		Employee employee=null;
		try {
		
		employee=this.employeeRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
		
	}
	
	//adding new employee 
	
	public Employee addEmployee(Employee e) {
		Employee result = employeeRepository.save(e);
		return result;
	}
	
	//delete employee detail
	public void deleteEmpDetail(int eid)
	{
		
		employeeRepository.deleteById(eid);
	}
	
	//update employee detail
	public void updateEmployee(Employee employee,int empId) {

		employee.setId(empId);
		employeeRepository.save(employee);
	}
}
