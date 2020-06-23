package com.soprasteria.dao;

import java.util.List;

import com.soprasteria.model.Employee;

public interface EmployeeDao {

	Employee addEmployee(Employee emp);
	
	List<Integer> getEmail();

	List<String> getTeamEmail(Integer emp);

}
