package com.enoca.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.api.model.Employee;
import com.enoca.api.service.EmployeeService;

@RestController
@RequestMapping("/rest-api/employee")
public class EmployeeController {
	
	@Autowired private EmployeeService employeeService;
	
	@PostMapping("/new")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.savEmployee(employee), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id){
		return new ResponseEntity<Employee>(employeeService.updatEmployee(employee,id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id){
		if(employeeService.deleteEmployee(id) == 1)
			return "Employee with id:"+id+" has been deleted successfully ";
		else 
			return "Error has occurred during deleting the record";
	}
	
	@GetMapping("")
	public List<Employee> listEmployee(){
		return employeeService.employees();
	}
	
	
	@PutMapping("/{em_id}/{co_id}")
	public int setCidtoEmployee(@PathVariable("em_id") int em_id, @PathVariable("co_id") int co_id){
		return employeeService.setEmployeetoCompany(em_id, co_id);
	}
	
	// Postman ( GET ) 
	// Getting employee id & years 
	@RequestMapping("/{em_id}/{years}")
	public Float calculateRaise(@PathVariable("em_id") int em_id, @PathVariable("years") int years) {
		return employeeService.raiseCalculator(em_id, years);
	}
	
	@GetMapping("/getByid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
}
