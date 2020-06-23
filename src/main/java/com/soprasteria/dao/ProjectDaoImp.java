package com.soprasteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soprasteria.model.Project;

@Repository
public class ProjectDaoImp implements ProjectDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public ProjectDaoImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
		
	@Override
	public List<Project> viewProject() {
      Query theQuery = entityManager.createQuery("from Project");
		
		List<Project> projects = theQuery.getResultList();	
		return projects;
	}
 
	
}
