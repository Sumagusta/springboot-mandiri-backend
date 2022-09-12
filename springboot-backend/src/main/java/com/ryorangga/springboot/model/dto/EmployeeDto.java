package com.ryorangga.springboot.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int id;
	private String name;
	private Date birthDate;
	private String positionName;
	private String genderName;
	private int idNumber;
}
