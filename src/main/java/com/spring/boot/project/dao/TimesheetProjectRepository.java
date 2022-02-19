package com.spring.boot.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.project.entity.TimesheetProject;

public interface TimesheetProjectRepository extends JpaRepository<TimesheetProject, Integer> {

}
