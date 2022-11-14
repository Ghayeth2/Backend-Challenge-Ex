package com.enoca.api.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;

@Data
@NoArgsConstructor
public class EmployeeJoin extends Object{
	
	public EmployeeJoin(String name, String cname, int age, float salary, Date workingYear) {
		super();
		this.name = name;
		this.cname = cname;
		this.age = age;
		this.salary = salary;
		this.workingYear = workingYear;
	}
	private String name;
	private String cname;
	private int age;
	private float salary;
	private Date workingYear;
}
