package com.soprasteria.service;

import java.util.List;

import com.soprasteria.model.Team;

public interface TeamService {

	List<Team> viewTeam();

	Team createTeam(Team team);

	Team getTeamId(String team_name);

}
