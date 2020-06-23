package com.soprasteria.service;

import java.util.List;

import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;

public interface EmployeeService {

	Employee addEmployee(Employee emp);
	
	List<Integer> getEmail();

	List<String> getTeamEmail(Integer emp);

}
