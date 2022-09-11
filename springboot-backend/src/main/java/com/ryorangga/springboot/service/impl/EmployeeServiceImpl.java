package com.ryorangga.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryorangga.springboot.dao.EmployeeDao;
import com.ryorangga.springboot.model.Employee;
import com.ryorangga.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public String saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int result = employeeDao.saveEmployee(employee);
		return "save employee success "+result;
	}

	@Override
	public String updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		int result = employeeDao.updateEmployee(id, employee);
		return "update employee success "+ result;
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		int result = employeeDao.deleteEmployee(id);
		return "delete employee success "+result;
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.findAllEmployee();
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployeeById(id);
	}

}
