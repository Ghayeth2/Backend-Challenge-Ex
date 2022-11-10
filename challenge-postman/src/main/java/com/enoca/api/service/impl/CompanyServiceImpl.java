package com.enoca.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.enoca.api.exception.NotFoundException;
import com.enoca.api.model.Company;
import com.enoca.api.repository.CompanyRespository;
import com.enoca.api.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{
	@Autowired private CompanyRespository companyRepo;

	@Override
	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}
    
	@Override
	public Company updateCompany(Company company, int id) {
		Company company2 = null;
		if(companyRepo.existsById(id)) {
			company2 = companyRepo.getById(id);
			company2.setId(id);
			company2.setName(company.getName());
			company2.setEmployees(company.getEmployees());
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
			companyRepo.getById(id);
		else {
			try {
				throw new NotFoundException("No such company with provided id => "+id);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " " + e.getClass() + " " + e.getStackTrace());
			}
		}
		return company;
	}

//	@Override
//	public List<Object[]> getCompanyEmployees() {
//		return companyRepo.getCompanyEmployees();
//	}
}
