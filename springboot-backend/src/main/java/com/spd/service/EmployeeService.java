package com.spd.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spd.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee emp);
	
	//public ResponseEntity<Employee> getEmployeeById(Long id);
	
	public ResponseEntity<Employee> updateEmployee(Long id,Employee emp);
	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id);

	ResponseEntity<Employee> getEmployeeById(Long id);
}
