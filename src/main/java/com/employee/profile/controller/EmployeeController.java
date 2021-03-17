package com.employee.profile.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.profile.employeeDetails.Employee;
import com.employee.profile.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//get all info 
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee() {
		
		
		List<Employee> list=employeeService.getAllEmployees();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	
	//get single emp detail
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee1(@PathVariable("id")int id) {
		
		Employee employee = employeeService.getEmployeeById(id);
		if(employee==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		return ResponseEntity.of(Optional.of(employee));
		
	}
	 
	
	//add emp
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee e=null;
				
				try {
					e=this.employeeService.addEmployee(employee);
					return ResponseEntity.of(Optional.of(e));
				}
				catch(Exception a) 
				{
					a.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
		
		
	}
	
	//delete emp detail
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<Void> deleteEmpDetail(@PathVariable("empId") int empId)
	{	
		try {
		this.employeeService.deleteEmpDetail(empId);
		return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		}
	}
	
	
	//update emp detail
	@PutMapping("/employee/{empId}")
	public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("empId") int empId) {
		try {
		this.employeeService.updateEmployee(employee,empId);
		return  ResponseEntity.ok().body(employee);
		}
		catch(Exception e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
