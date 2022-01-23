/*
 * 
 */
package com.welcome;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.utils.Choice;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws IOException, SQLException {
        
//		File dir = new File("./");
//		System.out.println(dir.getAbsolutePath());
		
		
		System.out.println("***************************************");
		System.out.println("******Welcome to Bank Admin Page*******");
		System.out.println("***************************************");
		
		boolean choice = true;
		
		while(choice) {
			int temp = Choice.choice();
			if(temp==4) {
				choice = false;
			}
		}
		
		System.out.println("************Thank You!****************");
		
	}

}
