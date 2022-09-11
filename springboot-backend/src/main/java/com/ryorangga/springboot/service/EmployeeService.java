package com.ryorangga.springboot.service;

import java.util.List;

import com.ryorangga.springboot.model.Employee;

public interface EmployeeService {
	public String saveEmployee(Employee employee);
	public List<Employee> findAllEmployee();
	 public String updateEmployee(int id, Employee employee);
	 public String deleteEmployee(int id);
	 public Employee findEmployeeById(int id);
}
