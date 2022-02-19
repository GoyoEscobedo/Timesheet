package com.spring.boot.project.service;

import java.util.List;

import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetProject;

public interface TimesheetProjectService {
	
	public List<TimesheetProject> findAll();
	
	public TimesheetProject findById(int theId);
		
	public void save(TimesheetProject theProject);
	
	public void deleteById(int theId);
	

}
