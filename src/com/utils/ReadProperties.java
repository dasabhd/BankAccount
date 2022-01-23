package com.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	private String className;
	private String dbURL;
	private String userID;
	private String pass;
	
	

	public String getClassName() {
		return className;
	}



	public String getDbURL() {
		return dbURL;
	}



	public String getUserID() {
		return userID;
	}



	public String getPass() {
		return pass;
	}



	public ReadProperties() throws IOException {
		
		
		FileReader reader = new FileReader("E:\\Learning\\Servlets\\SBIAccount\\lib\\connection.properties");
		Properties prop = new Properties();
		prop.load(reader);
		
		this.className = prop.getProperty("className");
		this.dbURL = prop.getProperty("DB_URL");
		this.userID = prop.getProperty("USER_ID");
		this.pass = prop.getProperty("PASS");
		
	}
	
}
