package com.capgemini.servlets.dao;

import java.util.List;

import com.capgemini.servlets.dto.EmployeeInfoBeans;

public interface EmployeeDAO {
	public EmployeeInfoBeans authentication(int id, String password);
	
	public EmployeeInfoBeans getEmployeeDetailsById(int id);
	
	public boolean deleteEmployeeInfo(int id);
	
	public boolean updateEmployeeInfo(EmployeeInfoBeans bean);
	
	public boolean createEmployeeInfo(EmployeeInfoBeans bean);
	
	public List<EmployeeInfoBeans> getAllEmployeeDetail();
}
