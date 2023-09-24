package com.frag.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	private Connection connection;
	
	public EmployeeService(Connection connection) {
		super();
		this.connection = connection;
	}
	
	/******************** SELECT ********************/
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT * FROM EMPLOYEES";
		
		try (Statement statement = connection.createStatement(); 
				ResultSet rs = statement.executeQuery(query);) 
		{
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setFirstname(rs.getString("firstname"));
				employee.setLastname(rs.getString("lastname"));
				employees.add(employee);
			}
		} 
		catch(Exception e) {e.printStackTrace();}
		
		return employees;
	}
	
	public void showEmployees() {
		for (Employee employee : getEmployees()) {
			System.out.println(employee.toString());
		}
		for (int i=0; i<50; i++) System.out.print("_");
		System.out.println();
		System.out.println();
	}
	
	/******************** UPDATES ********************/
	public void execute(String query) {
		try(Statement statement = this.connection.createStatement();) {
			statement.executeUpdate(query);
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public void addEmployee(int id, String firstname, String lastname) {
		String query = String.format("INSERT INTO EMPLOYEES VALUES(%d, '%s', '%s');", id, firstname, lastname);
		execute(query);
	}
	public void updateEmployee(int id, String column, String value) {
		String query = String.format("UPDATE EMPLOYEES SET %s = '%s' WHERE id = %d;", column, value, id);
		execute(query);	
	}
	public void deleteEmployee(int id) {
		String query = String.format("DELETE FROM EMPLOYEES WHERE id = %d;", id); 
		execute(query);
	}
}
