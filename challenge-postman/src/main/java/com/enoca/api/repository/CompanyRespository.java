package com.enoca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.api.model.Company;

public interface CompanyRespository extends JpaRepository<Company,Integer>{

}
