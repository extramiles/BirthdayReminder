package com.soprasteria.dao;

import java.util.List;

import com.soprasteria.model.Team;

public interface TeamDao {

	List<Team> viewTeam();

	Team createTeam(Team team);

	Team getTeamId(String team_name);

}
