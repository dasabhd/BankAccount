package com.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.userdetails.UserDetails;
import com.utils.ReadProperties;

public class AccountDAO {

	private Connection conn;
	
	public AccountDAO() throws IOException {
		
		ReadProperties prop = new ReadProperties();
		
		try {
		   
			Class.forName(prop.getClassName());
		    
			this.conn = DriverManager.
					getConnection(prop.getDbURL(), prop.getUserID(), prop.getPass());
		   
		}catch(Exception e) {
			System.out.println("Problem in connection to database..");
		}
	}
	
	public void createAccount() throws IOException, SQLException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		UserDetails usd = new UserDetails();
		System.out.println();
		System.out.println("Enter the first name: ");
		usd.setFirstName(in.readLine());
		System.out.println("Enter the second name: ");
		usd.setLastName(in.readLine());
		System.out.println("Add Balance Amount: ");
		usd.setAccountBalance(Integer.parseInt(in.readLine()));
		
		Statement stmt = conn.createStatement();
		
		int res = stmt.executeUpdate("insert into sbiaccount (firstname, lastname, bal)\r\n"
				+ "values (\""+usd.getFirstName()+"\",\""+usd.getLastName()+"\",\""
				+usd.getAccountBalance()+"\");\r\n"
				+ "");
		
		System.out.println("-------"+res+" no of records inserted-------");
	}
	
	
	public void viewAccountDetails() throws NumberFormatException, IOException, SQLException {
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		UserDetails usd = new UserDetails();
		System.out.println();
		System.out.println("Enter the account number: ");
		usd.setAccountNumber(Integer.parseInt(in.readLine()));
		
		Statement stmt = conn.createStatement();
		
		ResultSet result =  stmt.executeQuery("Select * from sbiaccount where accountno="+usd.getAccountNumber());
		
		while(result.next()) {
			
			System.out.println("<---------------------------->\n");
			System.out.println("First Name: "+result.getString(2));
			System.out.println("Last Name: "+result.getString(3));
			System.out.println("Account Balance: "+result.getString(4)+"\n");
			System.out.println("<---------------------------->\n");
		}
		
	}
	
	public void updateBalance() throws NumberFormatException, IOException, SQLException {
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		UserDetails usd = new UserDetails();
		System.out.println();
		System.out.println("Enter the account number: ");
		usd.setAccountNumber(Integer.parseInt(in.readLine()));
		
		Statement stmt = conn.createStatement();
		
		ResultSet result =  stmt.executeQuery("Select * from sbiaccount where accountno="+usd.getAccountNumber());
		result.next();
		int currentBalance = Integer.parseInt(result.getString(4));
		
		System.out.println("Enter the amount to add: ");
		
		int bal = Integer.parseInt(in.readLine());
		
		currentBalance = currentBalance + bal;
		
		stmt.executeUpdate("Update sbiaccount Set bal ="+currentBalance+" where accountno="+usd.getAccountNumber());
		
        result =  stmt.executeQuery("Select * from sbiaccount where accountno="+usd.getAccountNumber());
		
		while(result.next()) {
			
			System.out.println("<--------Updated Record-------->\n");
			System.out.println("First Name: "+result.getString(2));
			System.out.println("Last Name: "+result.getString(3));
			System.out.println("Account Balance: "+result.getString(4)+"\n");
			System.out.println("<------------------------------>\n");
		}
		
	}
}
