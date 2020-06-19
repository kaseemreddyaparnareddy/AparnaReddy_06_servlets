package com.capgemini.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.servlets.dto.EmployeeInfoBeans;

@WebServlet("/AddEmployee")
public class AddServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get form data
		String empId= request.getParameter("id");
		int id=Integer.parseInt(empId);
		String empName= request.getParameter("name");
		String empAge= request.getParameter("age");
		int age=Integer.parseInt(empAge);
		String empSalary= request.getParameter("salary");
		int salary=Integer.parseInt(empSalary);
		String empDesignation= request.getParameter("designation");
		String empPass= request.getParameter("password");
		
		EmployeeInfoBeans employee = new EmployeeInfoBeans();
		employee.setAge(age);
		employee.setDesignation(empDesignation);
		employee.setId(id);
		employee.setName(empName);
		employee.setPassword(empPass);
		employee.setSalary(salary);
		
	 PrintWriter out = response.getWriter(); 
    out.println("<html><body><b>Successfully Inserted"
            + "</b></body></html>"); 
	}

}
