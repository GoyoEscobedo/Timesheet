package com.spring.boot.project.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.service.TimesheetService;

@RestController
@RequestMapping("/api")
public class TimesheetRestController {
	
	private TimesheetService timesheetService;
	
	@Autowired
	public TimesheetRestController(TimesheetService theTimesheetService) {
		timesheetService = theTimesheetService;
	}
	
	@GetMapping("/timesheets")
	public List<Timesheet> findAll(){
		return timesheetService.findAll();
		
	}
	
	@GetMapping("/timesheets/{timesheetId}")
	public Timesheet getTimesheet(@PathVariable int timesheetId) {
		
		Timesheet theTimesheet = timesheetService.findById(timesheetId);
		
		if(theTimesheet == null) {
			throw new RuntimeException("Timesheet id not found - " + timesheetId);
		}
		
		return theTimesheet;
	}
	
	@PostMapping("/timesheets")
	public Timesheet addTimesheet(@RequestBody Timesheet theTimesheet) {
		
		theTimesheet.setIdTimesheet(0);
		
		timesheetService.save(theTimesheet);
		
		return theTimesheet;
	}
	
	@PutMapping("/timesheets")
	public Timesheet updateTimesheet(@RequestBody Timesheet theTimesheet) {
				
		timesheetService.save(theTimesheet);
		
		return theTimesheet;
	}
	
	@DeleteMapping("/timesheets/{timesheetId}")
	public String deleteTimesheet(@PathVariable int timesheetId) {
		
		Timesheet theTimesheet = timesheetService.findById(timesheetId);
		
		if(theTimesheet == null) {
			throw new RuntimeException("Timesheet id not found - " + timesheetId);
		}
		
		timesheetService.deleteById(timesheetId);
		
		return "Timesheet deleted";
	}
	
	@GetMapping("/timesheets/manager/{managerId}")
	public List<Timesheet> findByIdManager(@PathVariable int managerId){
		return timesheetService.findByIdManager(managerId);
		
	}
	
	@GetMapping("/timesheets/employee/{employeeId}")
	public List<Timesheet> findByIdEmployee(@PathVariable int employeeId){
		return timesheetService.findByIdEmployee(employeeId);
		
	}
	

}
