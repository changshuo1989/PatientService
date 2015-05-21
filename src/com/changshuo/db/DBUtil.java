package com.changshuo.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {

	
	public static void main(String[] args){
		DBUtil util=new DBUtil();
		util.openConnection();
		
	}
	
	
	public Connection openConnection(){
		String driver=null;
		String url=null;
		String username=null;
		String password=null;
		
		
		try {
			Properties pro=new Properties();
			pro.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			username=pro.getProperty("usr");
			password=pro.getProperty("pwd");
			
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,password);
			System.out.println("Database Connection Success!");
			return conn;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void closeConnection(Connection conn){
		try {
			if(conn != null){
			conn.close();
			System.out.println("Database closeure sucess! ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
