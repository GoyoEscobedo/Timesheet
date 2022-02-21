package com.spring.boot.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_project")
	private int idProject;
	
	private String employee;

	public Project() {
		super();
	}

	public Project(int idProject, String employee) {
		super();
		this.idProject = idProject;
		this.employee = employee;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	
	
	

}
