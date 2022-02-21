package com.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.project.dao.EmployeeManagerRepository;
import com.spring.boot.project.dao.ProjectRepository;
import com.spring.boot.project.dao.TimesheetDetailRepository;
import com.spring.boot.project.entity.EmployeeManager;
import com.spring.boot.project.entity.Project;
import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetDetail;
import com.spring.boot.project.entity.TimesheetProject;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectRepository projectRepository;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository thepProjectRepository) {
		projectRepository = thepProjectRepository;
	}

	@Override
	public List<Project> findByEmployeeAndIdProject(String employee, int id) {
		// TODO Auto-generated method stub
		return projectRepository.findByEmployeeAndIdProject(employee, id);
	}


	}

	

