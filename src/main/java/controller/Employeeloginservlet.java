package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/employee_login")
public class Employeeloginservlet extends HttpServlet{
	EmployeeDao eDao=new EmployeeDao();
	Employee emp=new Employee();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String pass=req.getParameter("password");
		emp.setId(id);
		emp.setPassword(pass);
		PrintWriter pw=resp.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("employeelogin.jsp");
		
		boolean result=eDao.adminloginvalidate(emp);
		
		if(result) {
			HttpSession session=req.getSession();
			session.setAttribute("employeeId", id);
			resp.sendRedirect("employee_operation.jsp");
		}else {
			rd.include(req, resp);
			pw.println("<html><body>");
			pw.println("<center>Login Faild invalid id or password</center>");
			pw.println("</body></html>");
		}
		
	}
}
