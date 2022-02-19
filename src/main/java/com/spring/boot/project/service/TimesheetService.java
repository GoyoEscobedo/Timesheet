package com.spring.boot.project.service;

import java.util.List;

import com.spring.boot.project.entity.Timesheet;

public interface TimesheetService {
	
	public List<Timesheet> findAll();
	
	public Timesheet findById(int theId);
	
	public void save(Timesheet theTimesheet);
	
	public void deleteById(int theId);
	
	public List<Timesheet> findByIdManager(int idManager);
	
	public List<Timesheet> findByIdEmployee(int idEmployee);

	

}
