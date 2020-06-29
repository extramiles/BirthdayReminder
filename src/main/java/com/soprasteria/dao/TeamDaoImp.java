package com.soprasteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;
import com.soprasteria.model.Team;

@Repository
public class TeamDaoImp implements TeamDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public TeamDaoImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Team> viewTeam() {
      Query theQuery = entityManager.createQuery("from Team");
		List<Team> teams = theQuery.getResultList();	
		return teams;
	}

	@Override
	public Team createTeam(Team team) {
		return entityManager.merge(team);
	}

	@Override
	public Team getTeamId(String team_name) {
		Query query = entityManager.createQuery("SELECT  c FROM Team c WHERE c.team_name = :team_name" , Team.class);
		query.setParameter("team_name", team_name);
		  return  (Team) query.getSingleResult();
	}
	
}
