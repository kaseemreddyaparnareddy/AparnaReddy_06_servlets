package com.capgemini.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.servlets.dto.EmployeeInfoBeans;
import com.capgemini.servlets.services.EmployeeService;
import com.capgemini.servlets.services.EmployeesServiceImpl;

@WebServlet("/update")
public class UpdateServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id1");
		String name = req.getParameter("name");
		EmployeeInfoBeans user= new EmployeeInfoBeans();
		user.setId(Integer.parseInt(id));
		user.setName(name);

		EmployeeService service = new EmployeesServiceImpl();
		boolean check = service.updateEmployee(user);
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");

		if (check == true) {
			out.println("Updated sucessfull");
		} else {
			out.println("Updated unsucessfull");
		}
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}

