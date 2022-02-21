package com.spring.boot.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetProject;

public interface TimesheetProjectRepository extends JpaRepository<TimesheetProject, Integer> {
	
	public List<TimesheetProject> findByProjectIdAndTimesheet(int projectId, Timesheet timesheetId);

}
