package com.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.project.dao.TimesheetProjectRepository;
import com.spring.boot.project.dao.TimesheetRepository;
import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetProject;

@Service
public class TimesheetProjectServiceImpl implements TimesheetProjectService {
	
	private TimesheetProjectRepository timesheetProjectRepository;
	
	@Autowired
	public TimesheetProjectServiceImpl(TimesheetProjectRepository theTimesheetProjectRepository) {
		timesheetProjectRepository = theTimesheetProjectRepository;
	}

	@Override
	public List<TimesheetProject> findAll() {
		return timesheetProjectRepository.findAll();
	}

	@Override
	public void save(TimesheetProject theTimesheetProject) {
		timesheetProjectRepository.save(theTimesheetProject);
		
	}

	@Override
	public void deleteById(int theId) {
		timesheetProjectRepository.deleteById(theId);
	}
	
	@Override
	public TimesheetProject findById(int theId) {
		Optional<TimesheetProject> result = timesheetProjectRepository.findById(theId);
		
		TimesheetProject theTimesheetProject = null;
		
		if(result.isPresent()) {
			theTimesheetProject = result.get();
		}
		else {
			throw new RuntimeException("Did not find timesheet id " + theId);
		}
		return theTimesheetProject;
	}

}
