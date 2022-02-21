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
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.project.config.TimesheetErrorResponse;
import com.spring.boot.project.config.TimesheetNotFoundException;
import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetProject;
import com.spring.boot.project.service.TimesheetProjectService;
import com.spring.boot.project.service.TimesheetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class ManagerRestController {
	
	private TimesheetService timesheetService;
	private TimesheetProjectService timesheetProjectService;
	
	@Autowired
	public ManagerRestController(TimesheetService theTimesheetService, TimesheetProjectService theTimesheetProjectService) {
		timesheetService = theTimesheetService;
		timesheetProjectService = theTimesheetProjectService;
	}
	
	@Operation(summary = "Show all timesheets of Employees asosiated to this manager")
	@GetMapping("/timesheets/manager")
	public List<Timesheet> findByIdManager(@Parameter(description = "Show the timesheets of the loged manager")@AuthenticationPrincipal User user){
		return timesheetService.findByUserManager(user.getUsername());
		
	}
	
	@Operation(summary = "Search using filter by employee ID")
	@GetMapping("/timesheets/manager/{userEmployee}")
	public List<Timesheet> findByIdManagerFilterEmployee(@Parameter(description = "Search using filter by employee ID")@AuthenticationPrincipal User user, @PathVariable String userEmployee){
		if(timesheetService.findByUserManagerAndUserEmployee(user.getUsername(), userEmployee).isEmpty()) {
			throw new TimesheetNotFoundException("Not found");
		}
		return timesheetService.findByUserManagerAndUserEmployee(user.getUsername(), userEmployee);
		
	}
	
	@Operation(summary = "Change the status of the project on the timesheet")
	@PutMapping("/timesheets/manager/project/status/{timesheetProjectId}")
	public TimesheetProject updateStatus(@Parameter(description = "Using the timesheetproject ID")@RequestBody TimesheetProject theTimesheetProject, @PathVariable int timesheetProjectId) {		
		
		TimesheetProject theTimesheetProject2;
		theTimesheetProject2 = timesheetProjectService.findById(timesheetProjectId);
		
		theTimesheetProject2.setTimesheetStatudId(theTimesheetProject.getTimesheetStatudId());
		
		timesheetProjectService.save(theTimesheetProject2);
				
		return theTimesheetProject2;
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
