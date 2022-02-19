package com.spring.boot.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "timesheet_detail")
public class TimesheetDetail {
	
	@Id
	@Column(name = "timesheet_project_id")
	@JsonIgnore
	private int timesheetProjectId;
	
	private int monday;
	
	private int tuesday;
	
	private int wednesday;
	
	private int thursday;
	
	private int friday;
	
	private int saturday;
	
	private int sunday;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "timesheet_project_id")
	@JsonIgnore
    private TimesheetProject timesheetProject;

	public TimesheetDetail() {
	}

	public TimesheetDetail(int timesheetProjectId, int monday, int tuesday, int wednesday, int thursday, int friday,
			int saturday, int sunday, TimesheetProject timesheetProject) {
		super();
		this.timesheetProjectId = timesheetProjectId;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.timesheetProject = timesheetProject;
	}

	public int getTimesheetProjectId() {
		return timesheetProjectId;
	}

	public void setTimesheetProjectId(int timesheetProjectId) {
		this.timesheetProjectId = timesheetProjectId;
	}

	public int getMonday() {
		return monday;
	}

	public void setMonday(int monday) {
		this.monday = monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	public int getFriday() {
		return friday;
	}

	public void setFriday(int friday) {
		this.friday = friday;
	}

	public int getSaturday() {
		return saturday;
	}

	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}

	public int getSunday() {
		return sunday;
	}

	public void setSunday(int sunday) {
		this.sunday = sunday;
	}

	public TimesheetProject getTimesheetProject() {
		return timesheetProject;
	}

	public void setTimesheetProject(TimesheetProject timesheetProject) {
		this.timesheetProject = timesheetProject;
	}
	

	}

	