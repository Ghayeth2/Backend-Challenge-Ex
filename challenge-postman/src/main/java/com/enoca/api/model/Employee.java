package com.enoca.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	@Column(name = "salary")
	private float salary;
	@Column(name = "workingYear")
	private Date workingYear;
	@Column(name = "age")
	private int age;
	@ManyToOne()
    @JsonBackReference 
    @JoinColumn(name = "company_id",referencedColumnName = "id" )
	private Company company;
}
