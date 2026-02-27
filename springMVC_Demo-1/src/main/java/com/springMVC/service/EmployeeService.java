package com.springMVC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springMVC.model.Employee;
import com.springMVC.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
	public EmployeeService( EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
		
	}
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
	}
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stu
		employeeRepository.deleteById(id);
		
	}

}
