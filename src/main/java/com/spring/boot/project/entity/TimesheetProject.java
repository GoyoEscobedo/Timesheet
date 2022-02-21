package com.spring.boot.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "timesheet_project")
public class TimesheetProject{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timesheet_project_id")
	@JsonIgnore
	private int idTimesheetProject;
	
	@Column(name = "proyect_id")
	private int projectId;
	
	@Column(name = "timesheet_status_id")
	private int timesheetStatudId;
	
	@Column
	private String comment;
	
	@Column
	private String attachment;
	
	@Column(name = "total_hours")
	private int totalHours;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "timesheet_id")
	@JsonIgnore
	private Timesheet timesheet;
	
	@OneToOne(mappedBy = "timesheetProject", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TimesheetDetail timesheetDetail;
	
	public TimesheetProject() {
		
	}

	



	public TimesheetProject(int idTimesheetProject, int projectId, int timesheetStatudId, String comment,
			String attachment, int totalHours, Timesheet timesheet, TimesheetDetail timesheetDetail) {
		super();
		this.idTimesheetProject = idTimesheetProject;
		this.projectId = projectId;
		this.timesheetStatudId = timesheetStatudId;
		this.comment = comment;
		this.attachment = attachment;
		this.totalHours = totalHours;
		this.timesheet = timesheet;
		this.timesheetDetail = timesheetDetail;
	}


	public TimesheetDetail getTimesheetDetail() {
		return timesheetDetail;
	}


	public void setTimesheetDetail(TimesheetDetail timesheetDetail) {
		this.timesheetDetail = timesheetDetail;
	}


	public int getIdTimesheetProject() {
		return idTimesheetProject;
	}

	public void setIdTimesheetProject(int idTimesheetProject) {
		this.idTimesheetProject = idTimesheetProject;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getTimesheetStatudId() {
		return timesheetStatudId;
	}

	public void setTimesheetStatudId(int timesheetStatudId) {
		this.timesheetStatudId = timesheetStatudId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public Timesheet getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}

	
	
	
	
	

}
