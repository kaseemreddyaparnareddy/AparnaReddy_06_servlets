package com.capgemini.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.servlets.dao.EmployeeDAO;
import com.capgemini.servlets.dao.EmployeeJDBCimple;
import com.capgemini.servlets.dto.EmployeeInfoBeans;
import com.capgemini.servlets.services.EmployeeService;
import com.capgemini.servlets.services.EmployeesServiceImpl;;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeService employee = new EmployeesServiceImpl();
		EmployeeInfoBeans user = new EmployeeInfoBeans();

		String sid = req.getParameter("id");

		int id = Integer.parseInt(sid);

		boolean deleted = employee.deleteEmployee(user.getId());

		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<body>");

		if (deleted == true) {
			out.print("<h2 style = 'color:green'>Employee deleted successfully.....</h2>");
		} else {
			out.print("<h2 style = 'color:red'>Employee not deleted!!!!</h2>");
		}

		RequestDispatcher res = req.getRequestDispatcher("/home.html");
		res.include(req, resp);

		out.print("</body>");
		out.print("</html>");

	}

}
