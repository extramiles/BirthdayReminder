package com.soprasteria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soprasteria.dao.ProjectDao;
import com.soprasteria.model.Project;

@Service
@Transactional
public class ProjectServiceImp implements ProjectService {

	private ProjectDao projectDAO;
	
	@Autowired
	public ProjectServiceImp(ProjectDao theProjectDao) {
		projectDAO = theProjectDao;
	}


	@Override
	public List<Project> viewProject() {
		return projectDAO.viewProject();
	}
}
