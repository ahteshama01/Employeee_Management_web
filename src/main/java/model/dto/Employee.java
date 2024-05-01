package model.dto;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String password;
	private long phone;
	private String role;
	public Employee() {
		
	}
		public Employee(int id, String name, double salary, long phone, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.salary = salary;
		this.phone = phone;
		this.role = role;
	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	
		
}
