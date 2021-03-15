package com.spd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spd.entity.Employee;
import com.spd.exception.ResourceNotFoundException;
import com.spd.repository.EmployeeRespository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRespository employeeRespository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return employeeRespository.save(emp);
	}


	@Override
	public ResponseEntity<Employee> getEmployeeById(Long id) {
		Employee emp = employeeRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with Id: "+id));
		return ResponseEntity.ok(emp);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Long id, Employee emp) {
		logger.info("---EmployeeServiceImpl --- updateEmployee()");
		Employee employee = employeeRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with Id: "+id));
		employee.setFirstname(emp.getFirstname());
		employee.setLastname(emp.getLastname());
		employee.setEmailId(emp.getEmailId());
		
		Employee updatedEmp = employeeRespository.save(employee);
		
		return ResponseEntity.ok(updatedEmp);
	}

	@Override
	public ResponseEntity < Map < String, Boolean >> deleteEmployee(Long id) {
		Employee employee = employeeRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with Id: "+id));
		employeeRespository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
