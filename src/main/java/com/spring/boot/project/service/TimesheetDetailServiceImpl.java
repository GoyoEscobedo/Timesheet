package com.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.project.dao.TimesheetDetailRepository;
import com.spring.boot.project.entity.Timesheet;
import com.spring.boot.project.entity.TimesheetDetail;
import com.spring.boot.project.entity.TimesheetProject;

@Service
public class TimesheetDetailServiceImpl implements TimesheetDetailService {
	
	private TimesheetDetailRepository timesheetDetailRepository;
	
	@Autowired
	public TimesheetDetailServiceImpl(TimesheetDetailRepository theTimesheetDetailRepository) {
		timesheetDetailRepository = theTimesheetDetailRepository;
	}

	@Override
	public List<TimesheetDetail> findAll() {
		return timesheetDetailRepository.findAll();
	}

	@Override
	public void save(TimesheetDetail theTimesheetDetail) {
		timesheetDetailRepository.save(theTimesheetDetail);
		
	}

	@Override
	public void deleteById(int theId) {
		timesheetDetailRepository.deleteById(theId);
	}
	
	@Override
	public TimesheetDetail findById(int theId) {
		Optional<TimesheetDetail> result = timesheetDetailRepository.findById(theId);
		
		TimesheetDetail theTimesheetDetail = null;
		
		if(result.isPresent()) {
			theTimesheetDetail = result.get();
		}
		else {
			throw new RuntimeException("Did not find timesheet id " + theId);
		}
		return theTimesheetDetail;
	}

}
