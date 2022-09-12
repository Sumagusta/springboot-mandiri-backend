package com.ryorangga.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ryorangga.springboot.dao.EmployeeDao;
import com.ryorangga.springboot.model.Employee;
import com.ryorangga.springboot.model.dto.EmployeeDto;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int saveEmployee(Employee employee) {
		String query = "insert into t2_employee (name, birth_date, gender, id_number, position_id, is_delete)"
				+ " values (?,?,?,?,?,?)";
		
		int result = jdbc.update(query, new Object[] {employee.getName(), employee.getBirthDate(), employee.getGender(), employee.getIdNumber(), employee.getPositionId(), employee.getIsDelete()});
		return result;
	}

	@Override
	public int updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		String query = "update t2_employee set name=?, birth_date=?, gender=?, id_number=?, position_id=?, is_delete=? where id=?";
		int result = jdbc.update(query, new Object[] {employee.getName(), employee.getBirthDate(), employee.getGender(), employee.getIdNumber(), employee.getPositionId(), employee.getIsDelete(), id});
		return result;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String query = "delete from t2_employee where id=?";
		int result = jdbc.update(query, id);
		return result;
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		String query = "select * from t2_employee";
		List<Employee> result = jdbc.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));
		return result;
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		String query = "select * from t2_employee t where t.id = ?";
		Employee result = jdbc.queryForObject(query, new BeanPropertyRowMapper<Employee>(Employee.class), id);
		return result;
	}

	@Override
	public List<EmployeeDto> findAllJoinEmployee() {
		// TODO Auto-generated method stub
		String query = "select t2.id, t2.name as name, t2.birth_date, t1.name as positionName, t3.name as genderName, t2.id_number from t2_employee t2 "
				+ "join t1_position t1 on t1.id = t2.position_id "
				+ "join t3_gender t3 on t3.id = t2.gender";
		List<EmployeeDto> result = jdbc.query(query, new BeanPropertyRowMapper<EmployeeDto>(EmployeeDto.class));
		return result;
	}

}
