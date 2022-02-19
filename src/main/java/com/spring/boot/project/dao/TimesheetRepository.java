package com.spring.boot.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
	
	List<Timesheet> findByIdManager(int idManager);
	
	List<Timesheet> findByIdEmployee(int idEmployee);
}
