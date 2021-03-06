package com.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.project.dao.TimesheetRepository;
import com.spring.boot.project.entity.Timesheet;

@Service
public class TimesheetServiceImpl implements TimesheetService {
	
	private TimesheetRepository timesheetRepository;
	
	@Autowired
	public TimesheetServiceImpl(TimesheetRepository theTimesheetRepository) {
		timesheetRepository = theTimesheetRepository;
	}

	@Override
	public List<Timesheet> findAll() {
		return timesheetRepository.findAll();
	}

	@Override
	public Timesheet findById(int theId) {
		Optional<Timesheet> result = timesheetRepository.findById(theId);
		
		Timesheet theTimesheet = null;
		
		if(result.isPresent()) {
			theTimesheet = result.get();
		}
		else {
			throw new RuntimeException("Did not find timesheet id " + theId);
		}
		return theTimesheet;
	}

	@Override
	public void save(Timesheet theTimesheet) {
		timesheetRepository.save(theTimesheet);
	}

	@Override
	public void deleteById(int theId) {
		timesheetRepository.deleteById(theId);
	}

	@Override
	public List<Timesheet> findByUserManager(String userManager) {
		// TODO Auto-generated method stub
		return timesheetRepository.findByUserManager(userManager);
	}

	@Override
	public List<Timesheet> findByUserEmployee(String userEmployee) {
		// TODO Auto-generated method stub
		return timesheetRepository.findByUserEmployee(userEmployee);
	}

	@Override
	public List<Timesheet> findByUserManagerAndUserEmployee(String userManager, String userEmployee) {
		// TODO Auto-generated method stub
		return timesheetRepository.findByUserManagerAndUserEmployee(userManager, userEmployee);
	}

}
