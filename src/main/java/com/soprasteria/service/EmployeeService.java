package com.soprasteria.service;

import java.util.List;

import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;

public interface EmployeeService {

	Employee addEmployee(Employee emp);
	
	List<Integer> getEmail();

	List<String> getTeamEmail(Integer emp);

	List<Employee> getEmployees();

	List<Employee> getMyTeam(int team_id);

	Employee updateEmployeeTeam(int employee_id, int team_id);

	Employee updateBalance(int employee_id, Integer team_id, Integer balance, String comments);
	
	Employee login(int username, String password);

	Employee updateTeamBalance(int employee_id, Integer team_id, Integer balance, String comments);

}
