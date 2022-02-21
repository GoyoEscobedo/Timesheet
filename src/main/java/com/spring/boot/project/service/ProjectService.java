package com.spring.boot.project.service;

import java.util.List;

import com.spring.boot.project.entity.EmployeeManager;
import com.spring.boot.project.entity.Project;

public interface ProjectService {
	
	public List<Project> findByEmployeeAndIdProject(String employee, int id);
	
}
