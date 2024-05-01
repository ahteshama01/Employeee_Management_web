package model.dao;

import java.sql.Statement;

import java.io.FileInputStream; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dto.Employee;


public class EmployeeDao {
	String url;
	String user;
	String password;
	Connection con;
	FileInputStream fis;
	Properties property=new Properties();
	PreparedStatement ps;
	ResultSet rs;
	Statement stm;
	List<Employee> employeess= new ArrayList<Employee>();
	{
		
		try {
			Class.forName("org.postgresql.Driver");
			fis=new FileInputStream("/home/frikky/eclipse-workspace/Employeee_Management_web/db_config.properties");
			property.load(fis);
			url=property.getProperty("url");
			con=DriverManager.getConnection(url,property);
			System.out.println("Connection Established");
			stm = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
public boolean adminloginvalidate(Employee emp) {
	String query = "select password from employee where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(emp.getPassword())) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	
	return false;
	
}
public boolean insertEmployee(Employee emp) {
	String query="insert into employee values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setLong(4, emp.getPhone());
			ps.setString(5, emp.getPassword());
			ps.setString(6, emp.getRole());
			
			if(ps.executeUpdate()>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return false;
}

//view 
 public Employee viewEmployee(int id) {
	 String query="select * from employee where id=?";
	 try {
		 ps=con.prepareStatement(query);
		 ps.setInt(1, id);
		 rs=ps.executeQuery();
		 if(rs.next()) {
			 return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getLong(4),rs.getString(5),rs.getString(6));
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return null;
 }
	//all view
 
 public List<Employee> viewAllEmployee(){
	 String query="select * from employee";
	 try {
		 rs= stm.executeQuery(query);
		 if(rs.next()) {
			 employeess.clear();
			 do {
				 employeess.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getLong(4),rs.getString(5),rs.getString(6)));
				 
			 }while(rs.next());
		 }
		 return employeess;
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return null;
	 
 }
 
 //remove
 public boolean removeEmployee(int id) {
	 String query="delete from employee where id=?";
	 try {
		ps=con.prepareStatement(query);
		ps.setInt(1, id);
		if(ps.executeUpdate()>0) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return false;
 }
 
 //update
 
 public boolean updateEmployee(Employee emp) {
	 String query="update employee set name=?,salary=?,phone=?,password=?,role=? where id=?";
	 try {
		ps=con.prepareStatement(query);
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setLong(3,emp.getPhone());
		ps.setString(4, emp.getPassword());
		ps.setString(5, emp.getRole());
		ps.setInt(6, emp.getId());
		
		if(ps.executeUpdate()>0) {
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return false;
	 
 }
 
 
 
	
}
