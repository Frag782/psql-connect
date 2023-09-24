package com.frag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

import com.frag.employee.Employee;
import com.frag.employee.EmployeeService;

public class App {

	public static void main(String[] args) {
		Connection conn = DatabaseConnection.open("jdbc:postgresql:test", "test", "test");
		EmployeeService employeeService = new EmployeeService(conn);
		
		employeeService.showEmployees();
		
		//employeeService.addEmployee(4, "Pam", "Beesly");
		//employeeService.updateEmployee(4, "firstname", "Pamela");
		//employeeService.deleteEmployee(4);
		
		employeeService.showEmployees();
		
		DatabaseConnection.close(conn);
	}

}
