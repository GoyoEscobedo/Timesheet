package com.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.project.dao.EmployeeManagerRepository;
import com.spring.boot.project.dao.TimesheetDetailRepository;
import com.spring.boot.project.entity.EmployeeManager;
import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetDetail;
import com.spring.boot.project.entity.TimesheetProject;

@Service
public class EmployeeManagerServiceImpl implements EmployeeManagerService {
	
	private EmployeeManagerRepository employeeManagerRepository;
	
	@Autowired
	public EmployeeManagerServiceImpl(EmployeeManagerRepository theeEmployeeManagerRepository) {
		employeeManagerRepository = theeEmployeeManagerRepository;
	}

	@Override
	public List<EmployeeManager> findByEmployee(String employee) {
		// TODO Auto-generated method stub
		return employeeManagerRepository.findByEmployee(employee);
	}

	

}
