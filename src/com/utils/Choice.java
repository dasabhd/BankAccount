package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.database.AccountDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Choice.
 */
public class Choice {

	/**
	 * Choice.
	 *
	 * @return the int
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static int choice() throws IOException, SQLException {
		System.out.println("***************************************");
		System.out.println("**********Enter Your Choice************");
		System.out.println("***************************************");
		System.out.println("|        Press 1 For Account Creation            |");
		System.out.println("|  Press 2 For Show Details about Customer       |");
		System.out.println("|Press 3 For Update Details about Account Balance|");
		System.out.println("|             Press 4 for Exit                   |");
		System.out.println();
		
		int ch=0;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			ch = Integer.parseInt(read.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AccountDAO dao = new AccountDAO();
		
		switch(ch) {
		
		    case 1:
			    dao.createAccount();
		        break;
		    case 2:
		    	dao.viewAccountDetails();
		    	break;
		    case 3:
		    	dao.updateBalance();
		    	break;
		}
		
		return ch;
	}
	
}
