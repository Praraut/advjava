package com.employee.profile.employeeDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_table")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String first_name;
	private String last_name;
	private String job_title;
	private int job_id;
	private String emp_adress;
	private String state;
	private String email;
	private int phone_number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getEmp_adress() {
		return emp_adress;
	}
	public void setEmp_adress(String emp_adress) {
		this.emp_adress = emp_adress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public Employee(int id, String first_name, String last_name, String job_title, int job_id, String emp_adress,
			String state, String email, int phone_number) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.job_title = job_title;
		this.job_id = job_id;
		this.emp_adress = emp_adress;
		this.state = state;
		this.email = email;
		this.phone_number = phone_number;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", job_title="
				+ job_title + ", job_id=" + job_id + ", emp_adress=" + emp_adress + ", state=" + state + ", email="
				+ email + ", phone_number=" + phone_number + "]";
	}
	
}
