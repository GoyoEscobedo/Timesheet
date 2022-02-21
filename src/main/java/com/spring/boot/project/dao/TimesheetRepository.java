package com.spring.boot.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
	
	public List<Timesheet> findByUserManager(String userManager);
	
	public List<Timesheet> findByUserEmployee(String userEmployee);
	
	public List<Timesheet> findByUserManagerAndUserEmployee(String userManager, String userEmployee);
}
