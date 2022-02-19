package com.spring.boot.project.service;

import java.util.List;

import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetDetail;
import com.spring.boot.project.entity.TimesheetProject;

public interface TimesheetDetailService {
	
	public List<TimesheetDetail> findAll();
	
	public TimesheetDetail findById(int theId);
		
	public void save(TimesheetDetail theDetail);
	
	public void deleteById(int theId);
	

}
