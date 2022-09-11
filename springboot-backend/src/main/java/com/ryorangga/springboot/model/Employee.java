package com.ryorangga.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "T2_EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "position_id")
	private int positionId;
	
	@Column(name = "id_number")
	private int idNumber;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "is_delete")
	private int isDelete;
	
	
}
