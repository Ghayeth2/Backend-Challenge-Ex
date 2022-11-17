package com.enoca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enoca.api.model.Company;

import java.util.*;

public interface CompanyRespository extends JpaRepository<Company,Integer>{
//	@Query(value = "select * from employee e "
//			+ "join company c on e.company_id = c.id", nativeQuery = true)
//	public List<Object[]> employeeList();
}
