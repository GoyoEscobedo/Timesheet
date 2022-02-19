package com.spring.boot.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.TimesheetDetail;

public interface TimesheetDetailRepository extends JpaRepository<TimesheetDetail, Integer> {

}
