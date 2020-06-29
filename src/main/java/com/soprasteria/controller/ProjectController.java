package com.soprasteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.service.ProjectService;
import com.soprasteria.model.Project;

@RestController
@CrossOrigin()
@RequestMapping(value="/api")
public class ProjectController {

private ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService theProjectService) {
		projectService = theProjectService;
	}
	
	@GetMapping("getProjects")
	public List<Project> viewProject() {
		return this.projectService.viewProject();
		
	}
	
	
}
