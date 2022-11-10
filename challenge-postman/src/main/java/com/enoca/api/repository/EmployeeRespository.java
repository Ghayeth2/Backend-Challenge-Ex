package com.enoca.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.enoca.api.model.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer>{
	@Transactional
	@Modifying
	@Query(value = "UPDATE enoca.employee SET company_id = :co_id where id = :em_id",nativeQuery = true)
	public int setEmployeetoCompany( int em_id,  int co_id);
}
