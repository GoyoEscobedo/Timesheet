package com.spring.boot.project.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "timesheet")
public class Timesheet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_timesheet")
	private int idTimesheet;
	
	@Column(name = "start_date")
	private  Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "id_manager")
	private int idManager;
	
	@Column(name = "id_employee")
	private int idEmployee;
	
	@OneToMany(mappedBy = "timesheet", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<TimesheetProject> timesheetProjects;
	
	public Timesheet() {
		
	}
	

	public Timesheet(int idTimesheet, Date startDate, Date endDate, int idManager, int idEmployee,
			List<TimesheetProject> timesheetProjects) {
		super();
		this.idTimesheet = idTimesheet;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idManager = idManager;
		this.idEmployee = idEmployee;
		this.timesheetProjects = timesheetProjects;
	}



	public int getIdEmployee() {
		return idEmployee;
	}


	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}


	public int getIdManager() {
		return idManager;
	}


	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}


	public List<TimesheetProject> getTimesheetProjects() {
		return timesheetProjects;
	}



	public void setTimesheetProjects(List<TimesheetProject> timesheetProjects) {
		this.timesheetProjects = timesheetProjects;
	}



	public int getIdTimesheet() {
		return idTimesheet;
	}

	public void setIdTimesheet(int idTimesheet) {
		this.idTimesheet = idTimesheet;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
