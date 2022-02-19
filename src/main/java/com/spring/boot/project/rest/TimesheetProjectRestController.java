package com.spring.boot.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.project.entity.TimesheetDetail;
import com.spring.boot.project.entity.TimesheetProject;
import com.spring.boot.project.service.TimesheetDetailService;
import com.spring.boot.project.service.TimesheetProjectService;
import com.spring.boot.project.service.TimesheetService;

@RestController
@RequestMapping("/api")
public class TimesheetProjectRestController {
	
	private TimesheetProjectService timesheetProjectService;
	private TimesheetService timesheetService;
	private TimesheetDetailService timesheetDetailService;
	
	@Autowired
	public TimesheetProjectRestController(TimesheetProjectService theTimesheetProjectService, 
			TimesheetService theTimesheetService, TimesheetDetailService theTimesheetDetailService) {
		timesheetProjectService = theTimesheetProjectService;
		timesheetService = theTimesheetService;
		timesheetDetailService = theTimesheetDetailService;
	}
	
	@GetMapping("/timesheets/project")
	public List<TimesheetProject> findAll(){
		return timesheetProjectService.findAll();
		
	}
	
	
	@PostMapping("/timesheets/{timesheetId}/project")
	public TimesheetProject addProject(@RequestBody TimesheetProject theTimesheetProject, @PathVariable int timesheetId) {
		
		theTimesheetProject.setIdTimesheetProject(0);
		
		theTimesheetProject.setTotalHours(0);
		
		theTimesheetProject.setTimesheetStatudId(1);
		
		theTimesheetProject.setTimesheet(timesheetService.findById(timesheetId));
		
		timesheetProjectService.save(theTimesheetProject);

		
		return theTimesheetProject;
	}
	
	@PostMapping("/timesheets/project/{timesheetProjectId}")
	public TimesheetProject addProjectHours(@RequestBody TimesheetDetail theTimesheetDetail, @PathVariable int timesheetProjectId) {
		
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
		
		return timesheetProjectService.findById(timesheetProjectId);
	}
	
	@PutMapping("/timesheets/project")
	public TimesheetProject updateTimesheet(@RequestBody TimesheetProject theTimesheet) {
				
		timesheetProjectService.save(theTimesheet);
		
		return theTimesheet;
	}
	
	@PutMapping("/timesheets/project/{timesheetProjectId}")
	public TimesheetProject updateStatus(@RequestBody TimesheetProject theTimesheetProject, @PathVariable int timesheetProjectId) {		
		
		TimesheetProject theTimesheetProject2;
		theTimesheetProject2 = timesheetProjectService.findById(timesheetProjectId);
		
		theTimesheetProject2.setTimesheetStatudId(theTimesheetProject.getTimesheetStatudId());
		
		timesheetProjectService.save(theTimesheetProject2);
				
		return theTimesheetProject2;
	}
	
	

}
