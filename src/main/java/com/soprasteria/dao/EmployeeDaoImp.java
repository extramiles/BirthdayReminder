package com.soprasteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;

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
	@Override
	public List<Employee> getEmployees() {
      Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();	
		return employees;
	}
	@Override
	public List<Employee> getMyTeam(int team_id) {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT c FROM Employee c WHERE c.team_id = :teamId", Employee.class);
		query.setParameter("teamId", team_id);
		  return query.getResultList();
	}
	@Override
	public Employee updateEmployeeTeam(int employee_id,int team_id) {
		Query theQuery = entityManager.createQuery(
				"update Employee c set c.team_id=:team_id where c.employee_id=:employee_id");

           theQuery.setParameter("employee_id", employee_id);
           theQuery.setParameter("team_id", team_id);
           theQuery.executeUpdate();
           return null;
	}
	@Override
	public Employee updatePayment(int employee_id, Integer team_id, Integer balance, String comments) {
		Query theQuery = entityManager.createQuery(
				"update Employee c set c.balance = c.balance - :balance where c.employee_id=:employee_id");

           theQuery.setParameter("employee_id", employee_id);
           theQuery.setParameter("balance", balance);
           theQuery.executeUpdate();
           
           Query theQuery1 = entityManager.createQuery(
   				"update Employee c set c.balance = c.balance + :balance where c.role='spoc' and c.team_id=:team_id"); 
           
           theQuery1.setParameter("team_id", team_id);
           theQuery1.setParameter("balance", balance);
           theQuery1.executeUpdate();
           return null;
	}
	@Override
	public Employee login(int username, String password) {
		Query query = entityManager.createQuery("SELECT c FROM Employee c WHERE c.employee_id = :employee_id and c.password = :password", Employee.class);
		query.setParameter("employee_id", username);
		query.setParameter("password", password);
		  return (Employee) query.getSingleResult();
	}
	@Override
	public Employee updateTeamBalance(int employee_id, Integer team_id, Integer balance, String comments) {
		Query theQuery1 = entityManager.createQuery(
   				"update Employee c set c.balance = c.balance - :balance , c.comments = CONCAT(c.comments,:comments) where employee_id=:employee_id and c.team_id=:team_id"); 
		   theQuery1.setParameter("employee_id", employee_id);
		   theQuery1.setParameter("team_id", team_id);
		   theQuery1.setParameter("balance", balance);
           theQuery1.setParameter("comments", comments);
           theQuery1.executeUpdate();
           return null;
	}

	
}
