package com.soprasteria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soprasteria.dao.EmployeeDao;
import com.soprasteria.dao.TeamDao;
import com.soprasteria.model.Employee;
import com.soprasteria.model.Team;

@Service
@Transactional
public class TeamServiceImp implements TeamService {
	
	private TeamDao teamDAO;
	
	@Autowired
	public TeamServiceImp(TeamDao theTeamDao) {
		this.teamDAO = theTeamDao;
	}
	
	@Override
	public List<Team> viewTeam() {
		return teamDAO.viewTeam();
	}

	@Override
	public Team createTeam(Team team) {
		return teamDAO.createTeam(team);
	}

	@Override
	public Team getTeamId(String team_name) {
		return teamDAO.getTeamId(team_name);
	}

	

}
