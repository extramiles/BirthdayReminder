package com.soprasteria.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soprasteria.model.Employee;
import com.soprasteria.model.Project;
import com.soprasteria.service.EmployeeService;
import com.soprasteria.service.ProjectService;

@RestController
@CrossOrigin()
@RequestMapping(value="/api")
public class EmployeeController {

private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@PostMapping("addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
			/*@RequestParam("employee_id") int employee_id,
			@RequestParam("name") String name,
			@RequestParam("dob") Date dob,
			@RequestParam("email") String email,
			@RequestParam("team_id") int team_id,
			@RequestParam("anniversary_date") Date anniversary_date,
			@RequestParam("password") String password,
			@RequestParam("designation") String designation) throws Exception  {
				
				Employee emp =new Employee();
				emp.setEmployee_id(employee_id);
				emp.setName(name);
				emp.setDob(dob);
				emp.setEmail(email);
				emp.setTeam_id(team_id);
				emp.setAnniversary_date(anniversary_date);
				emp.setPassword(password);
				emp.setDesignation(designation);*/				
			
		return employeeService.addEmployee(emp);
		
	}
	
	@GetMapping("getEmail")
	public List<Integer> getEmail(){
		return employeeService.getEmail();
	}
	
	@GetMapping("getEmail/{emp}")
	public List<String> getEmail(@PathVariable int emp){
		return employeeService.getTeamEmail(emp);
	}
	
	@GetMapping("getEmployees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
		
	}
	@GetMapping("getMyTeam/{team_id}")
	public List<Employee> getMyTeam(@PathVariable int team_id) {
	
		return employeeService.getMyTeam(team_id);
	
	}
	
	@PostMapping("updateEmployeeTeam")
	public Employee updateEmployeeTeam(@RequestBody Employee emp) {		
			
		return employeeService.updateEmployeeTeam(emp.getEmployee_id(),emp.getTeam_id());
		
	}
	
	@PostMapping("updatePayment")
	public Employee updateBalance(@RequestBody Employee emp) {		
			
		return employeeService.updateBalance(emp.getEmployee_id(),emp.getTeam_id(),emp.getBalance(),emp.getComments());
		
	}
	
	@PostMapping("teamExpenditure")
	public Employee updateTeamBalance(@RequestBody Employee emp) {		
		
	return employeeService.updateTeamBalance(emp.getEmployee_id(),emp.getTeam_id(),emp.getBalance(),emp.getComments());
	
}
	
	@PostMapping("login" )
    public Employee showLoginPage(@RequestBody Employee  emp) throws IOException{
		
	
        return employeeService.login(emp.getEmployee_id(),emp.getPassword());
    }
	
	
	
}
