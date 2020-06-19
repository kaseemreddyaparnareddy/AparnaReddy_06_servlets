package com.capgemini.servlets.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.servlets.dto.EmployeeInfoBeans;
import com.capgemini.servlets.services.EmployeeService;
import com.capgemini.servlets.services.EmployeesServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private EmployeeService service= new EmployeesServiceImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  empIdVal = req.getParameter("id");
		int empId = Integer.parseInt(empIdVal);
		String password = req.getParameter("password");
		
		EmployeeInfoBeans employeeInfoBean = service.authentication(empId, password);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		if(employeeInfoBean != null) {
			
			HttpSession httpSession = req.getSession(true);
			httpSession.setAttribute("logged In sucessfully", employeeInfoBean);
			out.print("<h2 style='color :navy' > WELCOME !!"+ employeeInfoBean.getName()+"</h2>");
			RequestDispatcher dispatcher= req.getRequestDispatcher("./home.html");
			dispatcher.include(req,resp);
			
		}else {
			out.print("<h1 style='color :red' > Invaild Credentials !!</h1>");
			RequestDispatcher dispatcher= req.getRequestDispatcher("./login.html");
			dispatcher.include(req,resp);
		}
		
		out.print("<html>");
		out.print("<body>");
		
		
	}

}
