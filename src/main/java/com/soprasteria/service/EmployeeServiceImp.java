package com.soprasteria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soprasteria.dao.EmployeeDao;
import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{

private EmployeeDao employeeDAO;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDao theEmployeeDao) {
		employeeDAO = theEmployeeDao;
	}
	
	@Override
	public Employee addEmployee(Employee emp) {
		return employeeDAO.addEmployee(emp);
	}

	@Override
	public List<Integer> getEmail() {
		
		return employeeDAO.getEmail();
	}

	@Override
	public List<String> getTeamEmail(Integer emp) {
		
		return employeeDAO.getTeamEmail(emp);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	public List<Employee> getMyTeam(int team_id) {
		return employeeDAO.getMyTeam(team_id);
	}

	@Override
	public Employee updateEmployeeTeam(int employee_id, int team_id) {
		return employeeDAO.updateEmployeeTeam(employee_id,team_id);
	}

	@Override
	public Employee updateBalance(int employee_id, Integer team_id, Integer balance, String comments) {
		return employeeDAO.updatePayment(employee_id, team_id, balance, comments);
	}

	@Override
	public Employee login(int username, String password) {
		return employeeDAO.login(username,password);
	}

	@Override
	public Employee updateTeamBalance(int employee_id, Integer team_id, Integer balance, String comments) {
		return employeeDAO.updateTeamBalance(employee_id, team_id, balance, comments);
	}

}
