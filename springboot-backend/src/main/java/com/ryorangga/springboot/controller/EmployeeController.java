package com.ryorangga.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryorangga.springboot.dao.EmployeeDao;
import com.ryorangga.springboot.exception.ResourceNotFoundException;
import com.ryorangga.springboot.model.Employee;
import com.ryorangga.springboot.repository.EmployeeRepository;
import com.ryorangga.springboot.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		//return employeeRepository.findAll();
		return employeeService.findAllEmployee();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public void createEmployee(@RequestBody Employee employee) {
		//employeeRepository.save(employee);
		employeeService.saveEmployee(employee);
		
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		
		Employee result = employeeService.findEmployeeById(id);
		return ResponseEntity.ok(result);
	}
	
	// update employee rest api
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody Employee employee){

		employeeService.updateEmployee(id, employee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){

		employeeService.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
