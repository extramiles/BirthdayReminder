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

}
