package com.spring.boot.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.project.config.TimesheetErrorResponse;
import com.spring.boot.project.config.TimesheetNotFoundException;
import com.spring.boot.project.entity.EmployeeManager;
import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetDetail;
import com.spring.boot.project.entity.TimesheetProject;
import com.spring.boot.project.service.EmployeeManagerService;
import com.spring.boot.project.service.ProjectService;
import com.spring.boot.project.service.TimesheetDetailService;
import com.spring.boot.project.service.TimesheetProjectService;
import com.spring.boot.project.service.TimesheetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class EmployeeRestController {
	
	private TimesheetProjectService timesheetProjectService;
	private TimesheetService timesheetService;
	private TimesheetDetailService timesheetDetailService;
	private ProjectService projectService;
	private EmployeeManagerService employeeManagerService;
	
	@Autowired
	public EmployeeRestController(TimesheetProjectService theTimesheetProjectService, 
			TimesheetService theTimesheetService, TimesheetDetailService theTimesheetDetailService,
			ProjectService theProjectService, EmployeeManagerService thEmployeeManagerService) {
		timesheetProjectService = theTimesheetProjectService;
		timesheetService = theTimesheetService;
		timesheetDetailService = theTimesheetDetailService;
		projectService = theProjectService;
		employeeManagerService = thEmployeeManagerService;
	}
	
	@Operation(summary = "Add a new project to an existing Timesheet")
	@PostMapping("/timesheets/employee/{timesheetId}/project")
	public TimesheetProject addProject(@Parameter(description = "Add a new project to an existing Timesheet")@RequestBody TimesheetProject theTimesheetProject, @PathVariable int timesheetId, @AuthenticationPrincipal User user) {
		
		theTimesheetProject.setIdTimesheetProject(0);
		
		theTimesheetProject.setTotalHours(0);
		
		theTimesheetProject.setTimesheetStatudId(1);
		
		theTimesheetProject.setTimesheet(timesheetService.findById(timesheetId));
		
		Timesheet timesheet;
		timesheet = timesheetService.findById(timesheetId);
		
		if(projectService.findByEmployeeAndIdProject(user.getUsername(), theTimesheetProject.getProjectId()).isEmpty()) {
			throw new TimesheetNotFoundException("User not assigned to this project");
		}else {
			if(timesheetProjectService.findByProjectIdAndTimesheet(theTimesheetProject.getProjectId(), timesheet).size() == 0) {
				timesheetProjectService.save(theTimesheetProject);
				
				return theTimesheetProject;
			}
			else {
				throw new TimesheetNotFoundException("Project already exist in this Timesheet");
			}
		}
	}
	
	@Operation(summary = "Assign hours to an existing project in the timesheet")
	@PostMapping("/timesheets/employee/project/{timesheetProjectId}/hours")
	public TimesheetDetail addProjectHours(@Parameter(description = "Assign hours using the timesheetprojectID")@RequestBody TimesheetDetail theTimesheetDetail, @PathVariable int timesheetProjectId) {
		
		TimesheetProject theTimesheetProject;
		
		theTimesheetProject = timesheetProjectService.findById(timesheetProjectId);
		
		theTimesheetDetail.setTimesheetProject(theTimesheetProject);
		
		timesheetDetailService.save(theTimesheetDetail);
		
		int totalHours = theTimesheetDetail.getMonday() + theTimesheetDetail.getTuesday() +
				theTimesheetDetail.getWednesday() + theTimesheetDetail.getThursday() + 
				theTimesheetDetail.getFriday() + theTimesheetDetail.getSaturday() +
				theTimesheetDetail.getSunday();
		
		theTimesheetProject.setTotalHours(totalHours);
		timesheetProjectService.save(theTimesheetProject);
		
		return theTimesheetDetail;
	}
	
	@Operation(summary = "Update project info it is rejected")
	@PutMapping("/timesheets/employee/project/update/{timesheetProjectId}")
	public TimesheetProject updateProjectTimesheet(@Parameter(description = "Update project info it is rejected usind the timesheetprojectID")@RequestBody TimesheetProject theTimesheet, @PathVariable int timesheetProjectId) {
		
		if(theTimesheet.getTimesheetStatudId() == 3) {
			theTimesheet.setIdTimesheetProject(timesheetProjectId);
			timesheetProjectService.save(theTimesheet);
			 return theTimesheet;
		}
		else {
			throw new TimesheetNotFoundException("You cant update this proyect timesheet info");
		}
						
	}
	
	@Operation(summary = "Update project hours timesheet if it is rejected")
	@PutMapping("/timesheets/employee/hours/update/{timesheetProjectId}")
	public TimesheetDetail updateProjectHours(@Parameter(description = "Update project hours timesheet if it is rejected using the timesheet projectID")@RequestBody TimesheetDetail theTimesheetDetail, @PathVariable int timesheetProjectId) {
		
		TimesheetProject theTimesheetProject;
		
		theTimesheetProject = timesheetProjectService.findById(timesheetProjectId);
		
		if(theTimesheetProject.getTimesheetStatudId() == 3) {
			theTimesheetDetail.setTimesheetProject(theTimesheetProject);
			timesheetDetailService.save(theTimesheetDetail);
			
			int totalHours = theTimesheetDetail.getMonday() + theTimesheetDetail.getTuesday() +
					theTimesheetDetail.getWednesday() + theTimesheetDetail.getThursday() + 
					theTimesheetDetail.getFriday() + theTimesheetDetail.getSaturday() +
					theTimesheetDetail.getSunday();
			
			theTimesheetProject.setTotalHours(totalHours);
			timesheetProjectService.save(theTimesheetProject);
			
			return theTimesheetDetail;
		}else {
			throw new TimesheetNotFoundException("You cant update this proyect timesheet info");
		}
	}
	
	@Operation(summary = "Show all the timesheets of the employee")
	@GetMapping("/timesheets/employee")
	public List<Timesheet> findByIdEmployee(@AuthenticationPrincipal User user){
		
		return timesheetService.findByUserEmployee(user.getUsername());
		
	}
	
	@Operation(summary = "Update timesheet")
	@PutMapping("/timesheets/employee")
	public Timesheet updateTimesheet(@Parameter(description = "Update timesheet")@RequestBody Timesheet theTimesheet) {
				
		timesheetService.save(theTimesheet);
		
		return theTimesheet;
	}
	
	@Operation(summary = "Add a new timesheet")
	@PostMapping("timesheets/employee/new")
	public Timesheet addTimesheet(@RequestBody Timesheet theTimesheet, @AuthenticationPrincipal User user) {
		
		theTimesheet.setIdTimesheet(0);
		theTimesheet.setUserEmployee(user.getUsername());
		
		List<EmployeeManager> list = employeeManagerService.findByEmployee(user.getUsername());
		
		EmployeeManager employeeManager = list.get(0);
		
		theTimesheet.setUserManager(employeeManager.getManager());
				
		timesheetService.save(theTimesheet);
		
		return theTimesheet;
	}
	
	@ExceptionHandler
	public ResponseEntity<TimesheetErrorResponse> handleException(TimesheetNotFoundException exc){
		
		TimesheetErrorResponse error = new TimesheetErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}

}
