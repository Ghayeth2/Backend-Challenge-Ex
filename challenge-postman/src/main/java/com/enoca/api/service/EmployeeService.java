package com.enoca.api.service;

import java.util.List;

import com.enoca.api.model.Employee;
import com.enoca.api.model.EmployeeJoin;

public interface EmployeeService {
	public Employee savEmployee(Employee employee);
	public Employee updatEmployee(Employee employee, int id);
	public Integer deleteEmployee(int id);
	public List<Employee> employees();
	public Employee getEmployeeById(int id);
	public Float raiseCalculator(int employee_id, int years);
	public int setEmployeetoCompany( int em_id,  int co_id);
//	public List<Object[]> listEmployees();
}
