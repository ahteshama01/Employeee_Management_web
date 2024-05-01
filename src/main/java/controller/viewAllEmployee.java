package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDao;
import model.dto.Employee;

@WebServlet("/view_all_emp")
public class viewAllEmployee extends HttpServlet{
	EmployeeDao eDao=new EmployeeDao();
	List<Employee> employeess;
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	employeess=eDao.viewAllEmployee();
	PrintWriter pw=resp.getWriter();
	RequestDispatcher rd1=req.getRequestDispatcher("admin_operation.jsp");
	RequestDispatcher rd2=req.getRequestDispatcher("view_all_emp.jsp");
	
	if(employeess!=null) {
		req.setAttribute("employeess", employeess);
		//req.setAttribute("demo", 20);
		rd2.forward(req, resp);
	}else {
		rd1.include(req, resp);
		pw.println("NOT FOUND");
	}
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	doGet(req, resp);
}
}
