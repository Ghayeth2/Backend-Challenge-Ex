package com.enoca.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.enoca.api.exception.NotFoundException;
import com.enoca.api.model.Employee;
import com.enoca.api.repository.EmployeeRespository;
import com.enoca.api.service.EmployeeService;

public class EmployeeServiceImp implements EmployeeService{

	@Autowired private EmployeeRespository employeeRepo;
	
	@Override
	public Employee savEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updatEmployee(Employee employee, int id) {
		Employee employee2 = null;
		if(employeeRepo.existsById(id)) {
			employee2 = employeeRepo.getById(id);
			employee2.setId(id);
			employee2.setName(employee.getName());
			employee2.setAge(employee.getAge());
			employee2.setSalary(employee.getSalary());
			System.out.println(employee.getWorkingYear());
			employee2.setWorkingYear(employee.getWorkingYear());
		}else {
			try {
				throw new NotFoundException("No such employee with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
		}
		/* A place that can LAMBDA be used in with throwing a costume Exception */
		return employeeRepo.save(employee2);
	}

	
	@Override
	public Integer deleteEmployee(int id) {
		Integer status = 0;
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
			status = 1;
		}else {
			try {
				throw new NotFoundException("No such employee with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
		}
		return status;
	}

	@Override
	public List<Employee> employees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		if(!(employeeRepo.existsById(id))) {
			try {
				throw new NotFoundException("No such employee with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
		}else {
			// employeeRepo.getById(id) => returns serializable entity 
			employee = employeeRepo.findById(id).get();
		}
		return employee;	
	}

	@Override
	public int setEmployeetoCompany(int em_id, int co_id) {
		return employeeRepo.setEmployeetoCompany(em_id, co_id);
	}

	@Override
	public Float raiseCalculator(int employee_id, int years) {
		Employee employee = employeeRepo.getById(employee_id);
		Float raise = 0.0f;
		raise = employee.getSalary() * 0.1f * years;
		if(employee.getAge() >= 20 && employee.getAge() <= 25)
			raise = employee.getSalary() * 0.1f + raise;
		else if(employee.getAge() >=26 && employee.getAge() <= 30)
			raise = employee.getSalary() * 0.08f + raise;
		else if(employee.getAge() >= 31 && employee.getAge() <= 36)
			raise = employee.getSalary() * 0.05f + raise;
		else 
			raise = employee.getSalary() * 0.03f + raise;
		return raise;
	}
}
