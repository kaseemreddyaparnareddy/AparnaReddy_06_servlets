package com.capgemini.servlets.services;

import java.util.List;

import com.capgemini.servlets.dto.EmployeeInfoBeans;

public interface EmployeeService {
	public EmployeeInfoBeans authentication(int id, String password);
	public EmployeeInfoBeans getEmployee(int id);
	public boolean addEmployee(EmployeeInfoBeans employeeBean);
	public boolean updateEmployee(EmployeeInfoBeans name);
	public boolean deleteEmployee(int id);
	public List<EmployeeInfoBeans> getAllEmployee();

}
