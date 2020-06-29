package com.soprasteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;
import com.soprasteria.model.Team;
import com.soprasteria.service.ProjectService;
import com.soprasteria.service.TeamService;

@RestController
@CrossOrigin()
@RequestMapping(value="/api")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	/*@Autowired
	public TeamController(TeamService theTeamService) {
		teamService = theTeamService;
	}*/
	
	@GetMapping("viewTeam")
	public List<Team> viewProject() {
		return this.teamService.viewTeam();
		
	}
	
	@PostMapping("createTeam")
	public Team createTeam(@RequestBody Team team) {
		System.out.println(team.getTeam_name());
		return this.teamService.createTeam(team);
		
	}
	
	@GetMapping("getTeamId")
	public Team getTeamId(@RequestBody Team team) {
		
		return teamService.getTeamId(team.getTeam_name());
	
	}
}
