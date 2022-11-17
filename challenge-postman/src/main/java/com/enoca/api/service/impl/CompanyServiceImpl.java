package com.enoca.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.api.exception.NotFoundException;
import com.enoca.api.model.Company;
import com.enoca.api.model.Employee;
import com.enoca.api.repository.CompanyRespository;
import com.enoca.api.repository.EmployeeRespository;
import com.enoca.api.service.CompanyService;
import com.enoca.api.service.EmployeeService;
@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired private CompanyRespository companyRepo;
	@Autowired private EmployeeRespository employeeRepo;

	@Override
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}
    
	@Override
	public Company updateCompany(Company company, int id) {
		Company company2 = null;
		if(companyRepo.existsById(id)) {
			company2 = companyRepo.findById(id).get();
			company2.setId(id);
			company2.setName(company.getName());
		}else {
			try {
				throw new NotFoundException("No such company with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
			
		}
		/* A place that can LAMBDA be used in with throwing a costume Exception */
		return companyRepo.save(company2);	
	}

	@Override
	public Company deleteCompany(int id) {
		Company company = null;
		if(companyRepo.existsById(id)) {
			company = companyRepo.getById(id);
			companyRepo.deleteById(id);
		}else {
			try {
				throw new NotFoundException("No such company with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
		}
		return company;
	}

	@Override
	public List<Company> companies() {
		return companyRepo.findAll();
	}
	@Override
	public Company getCompanyById(int id) {
		Company company = null;
		if(companyRepo.existsById(id)) 
			company =  companyRepo.findById(id).get();
		else {
			try {
				throw new NotFoundException("No such company with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
		}
		return company;
	}

	@Override
	public List<Employee> companyEmployees(int id) {
		List<Employee> employees = employeeRepo.findAll()
		.stream().filter( emp -> emp.getCompany().getId() == id)
		.collect(Collectors.toList());
		return employees;
	}
}
