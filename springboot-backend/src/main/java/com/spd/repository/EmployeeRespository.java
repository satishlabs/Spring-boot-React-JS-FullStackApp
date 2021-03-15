package com.spd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spd.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long>{

}
