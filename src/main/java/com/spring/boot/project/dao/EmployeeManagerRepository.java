package com.spring.boot.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.EmployeeManager;

public interface EmployeeManagerRepository extends JpaRepository<EmployeeManager, Integer> {
	
	public List<EmployeeManager> findByEmployee(String employee);

}
