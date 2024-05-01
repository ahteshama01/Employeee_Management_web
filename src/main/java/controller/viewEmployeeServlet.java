package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/view_emp")
public class viewEmployeeServlet extends HttpServlet{
	EmployeeDao eDao=new EmployeeDao();
	Employee emp;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		emp=eDao.viewEmployee(id);
		PrintWriter pw=resp.getWriter();
		
		RequestDispatcher rd1=req.getRequestDispatcher("view_emp.jsp");
		RequestDispatcher rd2=req.getRequestDispatcher("view.jsp");
		
		
		if(emp!=null) {
			req.setAttribute("employee", emp);
			rd1.forward(req, resp);
		}else {
			rd2.include(req, resp);
			pw.println("Employee Not Found");
		}
	}

}
