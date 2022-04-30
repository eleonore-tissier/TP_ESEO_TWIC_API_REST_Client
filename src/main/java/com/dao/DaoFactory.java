package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String username;
	private String password;
	
	public DaoFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e){
		}
		this.url = "jdbc:mysql://localhost:3306/ville_france";
		this.username = "root";
		this.password = "network";
	}
	
	public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
	}
}
