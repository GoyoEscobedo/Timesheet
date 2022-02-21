package com.spring.boot.project.service;

import java.util.List;

import com.spring.boot.project.entity.EmployeeManager;

public interface EmployeeManagerService {
	
	public List<EmployeeManager> findByEmployee(String employee);
			
}
