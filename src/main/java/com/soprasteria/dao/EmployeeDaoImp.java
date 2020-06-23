package com.soprasteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soprasteria.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public Employee addEmployee(Employee emp) {
		return entityManager.merge(emp);
	}
	@Override
	public List<Integer> getEmail() {
		Query query = entityManager.createNativeQuery("SELECT employee_id FROM Employee WHERE DATE_FORMAT(dob,'%m-%d') = DATE_FORMAT(NOW(),'%m-%d')");
			  return query.getResultList();
	}
	
	@Override
	public List<String> getTeamEmail(Integer emp) {
		Query query = entityManager.createNativeQuery("SELECT email FROM Employee WHERE team_id =(Select team_id from wpempdb.employee where employee_id =:employeeId)");
		query.setParameter("employeeId", emp);
		  return query.getResultList();
	}

}
