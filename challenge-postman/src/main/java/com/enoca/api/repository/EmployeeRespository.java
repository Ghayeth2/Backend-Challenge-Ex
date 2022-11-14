package com.enoca.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.enoca.api.model.Employee;
import com.enoca.api.model.EmployeeJoin;


public interface EmployeeRespository extends JpaRepository<Employee, Integer>{
	@Transactional
	@Modifying
	@Query(value = "UPDATE enoca.employee SET company_id = :co_id where id = :em_id",nativeQuery = true)
	public int setEmployeetoCompany( int em_id,  int co_id);
//	@Query(value = "select e.name as e_name, e.age, e.salary, e.working_year, c.name from employee e "
//			+ "join company c on e.company_id = c.id", nativeQuery = true)
//	public List<Object[]> employeeList();
}
