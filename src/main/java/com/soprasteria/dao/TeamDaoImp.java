package com.soprasteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
