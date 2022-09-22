package com.ryorangga.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ryorangga.springboot.model.Employee;
import com.ryorangga.springboot.model.dto.EmployeeDto;
import com.ryorangga.springboot.model.dto.PositionDto;


public interface EmployeeDao {
	
	 public int saveEmployee(Employee employee);
	 public List<Employee> findAllEmployee();
	 public List<EmployeeDto> findAllJoinEmployee();
	 public int updateEmployee(int id, Employee employee);
	 public int deleteEmployee(int id);
	 public Employee findEmployeeById(int id);
	 public List<PositionDto> findAllPosition();
	 
}
