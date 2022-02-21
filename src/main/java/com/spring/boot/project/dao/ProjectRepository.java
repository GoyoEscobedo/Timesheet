package com.spring.boot.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.EmployeeManager;
import com.spring.boot.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	public List<Project> findByEmployeeAndIdProject(String employee, int id);

}
