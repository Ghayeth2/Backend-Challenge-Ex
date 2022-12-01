package com.enoca.api.service;
import java.util.List;
import com.enoca.api.model.Company;
import com.enoca.api.model.Employee;

public interface CompanyService {
	public Company saveCompany(Company company);
	public Company updateCompany(Company company, int id);
	public Company deleteCompany(int id);
	public List<Company> companies();
	public List<Employee> companyEmployees(int id);
	public Company getCompanyById(int id);
//	public List<Object[]> getCompanyEmployees();
}
