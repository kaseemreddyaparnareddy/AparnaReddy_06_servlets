package com.capgemini.servlets.services;

import java.util.List;

import com.capgemini.servlets.dao.EmployeeDAO;
import com.capgemini.servlets.dao.EmployeeJDBCimple;
import com.capgemini.servlets.dto.EmployeeInfoBeans;

public class EmployeesServiceImpl implements EmployeeService {
    private EmployeeDAO dao = new EmployeeJDBCimple();
	@Override
	public EmployeeInfoBeans getEmployee(int id) {
		// TODO Auto-generated method stub
		if(id > 0) {
			return dao.getEmployeeDetailsById(id);
		}
		return null;
	}

	@Override
	public boolean addEmployee(EmployeeInfoBeans employeeBean) {
		// TODO Auto-generated method stub
		if(employeeBean != null) {
			return dao.createEmployeeInfo(employeeBean);
		}
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBeans name) {
		if(name != null) {
		return dao.updateEmployeeInfo(name);
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployeeInfo(id);
	}

	@Override
	public List<EmployeeInfoBeans> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployeeDetail();
	}

	@Override
	public EmployeeInfoBeans authentication(int id, String password) {
		// TODO Auto-generated method stub
		if(id > 1 || password != null || password.trim().isEmpty()) {
			return null;	
		}
		return dao.authentication(id, password);
	}

}
