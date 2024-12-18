package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.Repository;

@Service
public class EmployeeService {
	
	@Autowired
	private Repository employeeRe;
    public	Employee registerEmployee(Employee employee) {
    	Employee employee1=employeeRe.save(employee);
		return employee1;
	}
    public List<Employee> getAllEmployee(){
    	List<Employee> allEmployees=employeeRe.findAll();
    	return allEmployees;
    }
    public Employee getByEmployeeId(long id) {
    	Employee employee=employeeRe.getById(id);
    	return employee;
    }
    
    public String deleteEmployeeById(long id) {
    	try {
    	employeeRe.deleteById(id);
    	return "Employee is deleted succeessfully";
    	}
    	catch(Exception e) {
    		return "Employee is not deleted succeessfully ";
    	}
    }
    public Employee updateEmployeeById(Employee employee) {
    	Employee employee1=employeeRe.getById(employee.getId());
    	employee1.setFirstName(employee.getFirstName());
    	employee1.setLastName(employee.getLastName());
    	employee1.setEmailId(employee.getEmailId());
    	Employee employee2=employeeRe.save(employee);
    	return employee2;
    }
}
